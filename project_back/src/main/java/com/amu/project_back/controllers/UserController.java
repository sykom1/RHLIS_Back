package com.amu.project_back.controllers;
import com.amu.project_back.models.User;
import com.amu.project_back.repository.UserRepository;
import com.amu.project_back.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {




        @Autowired
        UserRepository repo;


        @Autowired
        UserService service;




        @GetMapping()
        public Iterable<User> getUser() {
            return repo.findAll();
        }

        @RequestMapping(value = "/page/{id}", method = RequestMethod.GET)
        Iterable<User> getByPage(@PathVariable int id) {

            Page<User> pageData = repo.findAll(PageRequest.of(id, 20));

            return pageData.getContent();

        }




        @GetMapping("/{id}")
        public User getUserById(@PathVariable Long id) {
            return repo.findById(id).get();
        }

        @GetMapping("/mail/{username}")
        public User getUserByusername(@PathVariable String username) {
            username = username.toLowerCase();
            return repo.findByUsername(username);
        }



        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        void deleteUser(@PathVariable Long id) {
            repo.deleteById(id);
        }


     /*   @PostMapping
        User postUser(@RequestBody UserDTO UserDTO) {
            ModelMapper mapper = new ModelMapper();
            User User = mapper.map(UserDTO, User.class);
            repo.save(User);
            return User;

        }
*/
        @PutMapping("/{id}")
        public ResponseEntity<User> putUser(@PathVariable Long id, @Valid @RequestBody User u, @RequestHeader(value = "Authorization") String authorize) throws Exception {
            String token = authorize.substring(7);
            User user = repo.findById(id)
                    .orElseThrow(() -> new Exception("User not found for this id : " + id));

            String password = u.getPassword();

            if(repo.findByToken(token) != null){
                user.setUsername(u.getUsername().toLowerCase());


                if(password != null && !password.equals("")){
                    user.setPassword(service.getEncodedPass(u.getPassword()));
                }


                /*
                user.setFirstname(u.getFirstname());
                user.setLastname(u.getLastname());
                user.setWebsite(u.getWebsite());
                user.setBirthday(u.getBirthday());
                user.setCv(u.getCv()); */

                final User updatedUser = repo.save(user);
                return ResponseEntity.ok(updatedUser);
            }
            return null;

        }




        @PostMapping("/signin")
        public String login(//
                            @RequestParam String username, //
                            @RequestParam String password) {


            return service.signin(username, password);
        }


        @PostMapping("/signup")
        public void signup(@RequestBody User User,
                           @RequestParam String username, //
                           @RequestParam String password,@RequestHeader(value = "Authorization") String authorize) {
            String token = authorize.substring(7);
            if(repo.findByToken(token) != null){
                User.setUsername(username.toLowerCase());
                User.setPassword(password);
                service.signup(User);
            }

        }



        @GetMapping("/refresh")
        //@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
        public String refresh(HttpServletRequest req) {
            return service.refresh(req.getRemoteUser());
        }

        @GetMapping("/logout")
        public void logout(@RequestHeader(value = "Authorization") String authorize) {
            String token = authorize.substring(7);
            service.logout(token);

        }

       

}
