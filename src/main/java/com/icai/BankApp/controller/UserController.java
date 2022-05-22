package com.icai.BankApp.controller;

import ch.qos.logback.classic.Logger;
import com.icai.BankApp.domain.Account;
import com.icai.BankApp.domain.User;
import com.icai.BankApp.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")

public class UserController {


    private static final Logger LOGGER = (Logger)
            LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers()) ;

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(userService.getUserById(id).get());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id) {
       Optional<User> user = userService.getUserById(id);
       if (user.isPresent()){
           userService.deleteUser(user.get());
       }
       return ResponseEntity.ok().body(user.isPresent());

    }

    @PostMapping( "/save")
    public ResponseEntity<User> saveUser( @RequestBody User user) {
        LOGGER.info(user.getFirstName());
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        User user1 = userService.save(user);
        return ResponseEntity
                .created(URI.create(String.format("/user/%s",user.getFirstName()))).body(user1);
    }

    @GetMapping("/byAccount/{id}")
    public ResponseEntity<List<User>> getAccByUser(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(userService.getUsersByAccount(id)) ;

    }
    @GetMapping("/getByName/{name}/{surname}")
    public ResponseEntity<User> getUserByName(@RequestBody String  name, @RequestBody String surname){
        return ResponseEntity.ok().body(userService.getUserByName(name,surname));
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<User> getUserByName(@PathVariable("email") String email){
        return ResponseEntity.ok().body(userService.getUserByEmail(email));
    }

}
