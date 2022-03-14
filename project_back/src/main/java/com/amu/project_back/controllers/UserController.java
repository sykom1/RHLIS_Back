package com.amu.project_back.controllers;

import com.amu.project_back.dto.UtilisateursDTO;
import com.amu.project_back.models.*;
import com.amu.project_back.repository.TokenEntityRepository;
import com.amu.project_back.repository.UserRepository;
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

import javax.annotation.PostConstruct;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class UserController {


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

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @PostConstruct
    public void init() {

        Utilisateur user = new Utilisateur("john@gmail.com", passwordEncoder.encode("john"), UserRole.UTILISATEUR, "john", "dough", new Date(), "0600000000");
        Utilisateur ref = new Utilisateur("ref@gmail.com", passwordEncoder.encode("ref"), UserRole.REFERENT, "ref", "boo", new Date(), "0600000000");
        Utilisateur service = new Utilisateur("service@gmail.com", passwordEncoder.encode("service"), UserRole.SERVICE_ADMINISTRATIF_FINANCIER, "service", "financier", new Date(), "0600000000");
        Utilisateur admin = new Utilisateur("admin@gmail.com", passwordEncoder.encode("admin"), UserRole.ADMIN, "admin", "admin", new Date(), "0600000000");
        repo.save(user);
        repo.save(ref);
        repo.save(service);
        repo.save(admin);
    }


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
    public Utilisateur modifyUser(@PathVariable Integer id,@RequestBody UtilisateursDTO userDTO) {
        ModelMapper mapper = new ModelMapper();
        Utilisateur newUser = mapper.map(userDTO, Utilisateur.class);
        Utilisateur oldUser = repo.findById(Long.valueOf(id)).get();
        oldUser.setUser(newUser);
        return repo.save(oldUser);
    }

    @PostMapping(value = "/users")
    public Utilisateur saveUser(@RequestBody UtilisateursDTO userDTO) {
        ModelMapper mapper = new ModelMapper();
        Utilisateur user = mapper.map(userDTO, Utilisateur.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }


   /* @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return repo.findById(id).get();
    } */



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



       

}
