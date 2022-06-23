package com.saikiran.artikle.service;

import com.saikiran.artikle.model.User;
import com.saikiran.artikle.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserHandler implements IUserHandler {
    private final UserRepository userRepository;

    @Override
    public Optional<User> getUserByEmail(User user) {
        return userRepository.findByEmail(user.getEmail());
    }
}

