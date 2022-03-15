package com.amu.project_back.controllers;

import com.amu.project_back.dto.UtilisateursDTO;
import com.amu.project_back.models.*;
import com.amu.project_back.models.enume.UserRole;
import com.amu.project_back.repository.*;
import com.amu.project_back.util.JwtUtil;
import org.aspectj.weaver.AnnotationNameValuePair;
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
import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    LisEquipeRepository eqrepo;

    @Autowired
    TokenEntityRepository tokenEntityRepository;

    @Autowired
    JwtUtil jwtTokenUtil;

    @Autowired
    LisPoleRepository polerepo;

    @Autowired
    AnnuaireEquipeRepository annrepo;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

/*
   @PostConstruct
    public void init() {

        Utilisateur user = new Utilisateur("john@gmail.com", passwordEncoder.encode("john"), UserRole.UTILISATEUR, "john", "dough", new Date(), "0600000001");
        Utilisateur ref = new Utilisateur("ref@gmail.com", passwordEncoder.encode("ref"), UserRole.REFERENT, "ref", "boo", new Date(), "0600000002");
        Utilisateur service = new Utilisateur("service@gmail.com", passwordEncoder.encode("service"), UserRole.SERVICE_ADMINISTRATIF_FINANCIER, "service", "financier", new Date(), "0600000000");
        Utilisateur admin = new Utilisateur("admin@gmail.com", passwordEncoder.encode("admin"), UserRole.ADMIN, "admin", "admin", new Date(), "0600000008");
        repo.save(user);
        repo.save(ref);
        repo.save(service);
        repo.save(admin);
    } */


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


    @GetMapping("/search")
    public Iterable<Utilisateur> getUsersBy(@PathParam("type") String type, @PathParam("name") String name ) {

        switch (type){
            case "role" : {
               return repo.findAllByRoleLike(UserRole.valueOf(name));
            }
            case "datea" : {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.FRENCH);
                LocalDate localdate = LocalDate.parse(name, formatter);
                java.sql.Date date =  java.sql.Date.valueOf(localdate);
                List<AnnuaireEquipe> annuaireEquipes = annrepo.findAllByDateArrive(date);
                List<Utilisateur> users = new ArrayList<>();
                for(AnnuaireEquipe annuaireEquipe : annuaireEquipes){
                    users.add(annuaireEquipe.getAnnuaire().getUser());
                }
                return users;
            }
            case "dated" : {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.FRENCH);
                LocalDate localdate = LocalDate.parse(name, formatter);
                java.sql.Date date =  java.sql.Date.valueOf(localdate);
                List<AnnuaireEquipe> annuaireEquipes = annrepo.findAllByDateSortie(date);
                List<Utilisateur> users = new ArrayList<>();
                for(AnnuaireEquipe annuaireEquipe : annuaireEquipes){
                    users.add(annuaireEquipe.getAnnuaire().getUser());
                }
                return users;
            }
            case "team" : {
                List<LisEquipe> teams = eqrepo.findAllByEquipesLabel(name);
                List<Utilisateur> users = new ArrayList<>();
                for (LisEquipe team : teams){
                    Utilisateur temp = team.getAnnuaireEquipe().getAnnuaire().getUser();
                    if(!users.contains(temp)){
                        users.add(temp);
                    }

                }
                return users;
            }
            case "pole" : {
                List<LisPole> poles = polerepo.findAllByName(name);
                List<Utilisateur> users = new ArrayList<>();
                for(LisPole pole : poles){
                    for(LisEquipe eq : pole.getLisEquipes()){
                        Utilisateur temp =eq.getAnnuaireEquipe().getAnnuaire().getUser();
                        if(!users.contains(temp)){
                            users.add(temp);
                        }
                    }
                }
                return users;
            }
            default:
                return null;
        }

    }







       

}
