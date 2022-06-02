package com.saikiran.artikle.service;

import com.saikiran.artikle.crud.UserRepository;
import com.saikiran.artikle.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserHandler implements IUserHandler {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
