package com.saikiran.artikle.service;

import com.saikiran.artikle.model.User;
import com.saikiran.artikle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserHandler implements IUserHandler {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }
}
