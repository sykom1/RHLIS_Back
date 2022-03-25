package com.amu.project_back.controllers;


import com.amu.project_back.exception.ExceptionsHandler;
import com.amu.project_back.models.*;
import com.amu.project_back.models.enume.Cnu;
import com.amu.project_back.models.enume.UserRole;
import com.amu.project_back.repository.*;
import com.amu.project_back.services.NotificationService;
import com.amu.project_back.util.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController extends ExceptionsHandler {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository repo;

    @Autowired
    UserDetailsService userDetailsService;



    @Autowired
    TokenEntityRepository tokenEntityRepository;

    @Autowired
    JwtUtil jwtTokenUtil;


    @Autowired
    NotificationService notificationService;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



    /*
   @PostConstruct
   public void init() {


        Utilisateur user = new Utilisateur("john@gmail.com", passwordEncoder.encode("john"), UserRole.UTILISATEUR, "john", "dough", new Date(), "0600051001");
        repo.save(user);
        Utilisateur ref = new Utilisateur("ref@gmail.com", passwordEncoder.encode("ref"), UserRole.REFERENT, "ref", "boo", new Date(), "0600000002");
        Utilisateur service = new Utilisateur("service@gmail.com", passwordEncoder.encode("service"), UserRole.SERVICE_ADMINISTRATIF_FINANCIER, "service", "financier", new Date(), "0600000000");
        Utilisateur admin = new Utilisateur("admin@gmail.com", passwordEncoder.encode("admin"), UserRole.ADMIN, "admin", "admin", new Date(), "0600000008");
        repo.save(ref);
        repo.save(service);
        repo.save(admin);
    }*/


    @GetMapping(value = "/users")
    public Iterable<Utilisateur> getUser() {
        return repo.findAll();
    }

    @GetMapping(value = "/users/{id}")
    public Utilisateur getUser(@PathVariable Integer id) {
        return repo.getById(Long.valueOf(id));
    }

    @GetMapping(value = "/referent/users/{id}")
    public Utilisateur getUserOfReferent(@PathVariable Integer id) {
        return repo.getById(Long.valueOf(id));
    }


    @PutMapping(value = "/users/{id}")
    public Utilisateur modifyUser(@PathVariable Integer id,@RequestBody Utilisateur newUser) {
        Utilisateur oldUser = repo.findById(Long.valueOf(id)).get();
        oldUser.setUser(newUser);
        return repo.save(oldUser);
    }

    @Autowired
    DirectoryRepository dirrepo;

    @PostMapping(value = "/users")
    public Utilisateur saveUser(@RequestBody Utilisateur user,@RequestParam long id) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Annuaire annuaire = new Annuaire();
        Annuaire ref = dirrepo.getById(id);
        annuaire.setReferent(ref);
        user.setDirectory(annuaire);
        notificationService.notifyAllSAF(user.getEmail(),ref.getUser().getFirstname() + " " + ref.getUser().getLastname());
        return repo.save(user);
    }

    @GetMapping(value = "/users/ref/{id}")
    public Iterable<Annuaire> getUsersByRef(@PathVariable long id){
        Annuaire ref = dirrepo.getById(id);
        return ref.getPersonnels();

    }

    @GetMapping(value = "/users/new")
    public Iterable<Utilisateur> getNewUsers(){
        return repo.findAllByIsnewTrueAndRoleNot(UserRole.ADMIN);
    }


    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                authenticationRequest.getPassword()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        Utilisateur user = repo.findByEmail(userDetails.getUsername());

        TokenEntity tokenEntity = tokenEntityRepository.findByUserEmail(user.getEmail());

        // Premiere Connexion
        if (tokenEntity == null) {
            tokenEntityRepository.save(new TokenEntity(jwt, user));
        } else {
            tokenEntity.setJwt(jwt);
            tokenEntityRepository.save(tokenEntity);
        }

        return ResponseEntity.ok(new AuthenticationResponse(jwt, user));
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<?> logout(@RequestBody String token) {
        TokenEntity tokenEnt = tokenEntityRepository.findByJwt(token);
        if(tokenEnt != null) {
            Integer tokenId = tokenEnt.getId();
            tokenEntityRepository.deleteById(tokenId);
        }
        return ResponseEntity.ok("Déconnexion réussite");
    }


    @PutMapping(value = "/users/{id}/password")
    public ResponseEntity<?> modifyPassword(@PathVariable long id, @RequestBody Map<String, String> passwords) {
        Utilisateur user = repo.findById(id).get();
        if(!passwords.get("newPassword").equals(passwords.get("confirmNewPassword"))) {
            return new ResponseEntity<>("Mot de passe et la confirmation ne sont pas identiques", HttpStatus.CONFLICT);
        }
        user.setPassword(passwordEncoder.encode(passwords.get("newPassword")));
        repo.save(user);
        return ResponseEntity.ok("Mot de passe changé");
    }

}
