package com.amu.project_back.controllers;

import com.amu.project_back.models.AuthenticationRequest;
import com.amu.project_back.models.AuthenticationResponse;
import com.amu.project_back.models.TokenEntity;
import com.amu.project_back.models.User;
import com.amu.project_back.repository.TokenEntityRepository;
import com.amu.project_back.repository.UserRepository;
import com.amu.project_back.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping(value = "/users")
    public Iterable<User> getUser() {
        return repo.findAll();
    }

    @GetMapping(value = "/users/{id}")
    public User getUser(@PathVariable Integer id) {
        return repo.getById(Long.valueOf(id));
    }

    @GetMapping(value = "/referent/users/{id}")
    public User getUserOfReferent(@PathVariable Integer id) {
        return repo.getById(Long.valueOf(id));
    }


    @PutMapping(value = "/users/{id}")
    public User modifyUser(@PathVariable Integer id, @RequestBody User newUser) {
        User oldUser = repo.findById(Long.valueOf(id)).get();
        oldUser.setUser(newUser);
        return repo.save(oldUser);
    }

    @PostMapping(value = "/users")
    public User saveUser(@RequestBody User user) {
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

        User user = repo.findByEmail(userDetails.getUsername());

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
