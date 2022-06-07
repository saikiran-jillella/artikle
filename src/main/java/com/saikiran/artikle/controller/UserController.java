package com.saikiran.artikle.controller;


import com.saikiran.artikle.model.User;
import com.saikiran.artikle.service.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserHandler userHandler;

    @Autowired
    public UserController(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @GetMapping("/{id}")
    public Optional<User> getArticle(@PathVariable Long id) {
        return userHandler.getUser(id);
    }


}
