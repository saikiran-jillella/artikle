package com.saikiran.artikle.controller;


import com.saikiran.artikle.model.User;
import com.saikiran.artikle.service.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserHandler userHandler;

    @Autowired
    public UserController(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @PostMapping
    public ResponseEntity<?> findUser(@RequestBody User user){
        Optional<User> foundUser = userHandler.getUserByEmail(user);
        if (foundUser.isPresent() ){
            if (user.getPassword().equals(foundUser.get().getPassword())){
                return ResponseEntity.status(HttpStatus.OK).body("Login Successful");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username or Password is Wrong");
    }

}
