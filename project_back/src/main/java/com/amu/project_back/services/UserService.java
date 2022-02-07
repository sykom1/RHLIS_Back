package com.amu.project_back.services;

import com.amu.project_back.exception.CustomException;
import com.amu.project_back.models.User;
import com.amu.project_back.repository.UserRepository;
import com.amu.project_back.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    
    public String signin(String username, String password) {
        try {
            username = username.toLowerCase();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            String token = jwtTokenProvider.createToken(username.toLowerCase(), userRepository.findByUsername(username));
            userRepository.findByUsername(username).setToken(token);
            userRepository.save(userRepository.findByUsername(username));

            return token;
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid UserName/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void signup(User user) {

        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            user.setRightId(1);

            userRepository.save(user);
        } else {
            throw new CustomException("UserName is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public  String getEncodedPass(String pass){
        return passwordEncoder.encode(pass);
    }


    public void delete(String UserName) {
        userRepository.deleteByUsername(UserName);
    }
    public void saveToken(String username,String password){
        userRepository.findByUsername(username).setToken(signin(username,password));
    }

    public User search(String UserName) {
        User User = userRepository.findByUsername(UserName);
        if (User == null) {
            throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return User;
    }

    public User whoami(HttpServletRequest req) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    public String refresh(String UserName) {
        return jwtTokenProvider.createToken(UserName, userRepository.findByUsername(UserName));
    }

    public void logout(String token){

        User user = userRepository.findByToken(token);
        if(user != null){
            jwtTokenProvider.invalidToker(user.getToken());
            user.setToken(null);
            userRepository.save(user);
        }
    }
}
