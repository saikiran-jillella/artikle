package com.saikiran.artikle.service;

import com.saikiran.artikle.model.User;
import com.saikiran.artikle.repository.UserRepository;

import java.util.Optional;

public interface IUserHandler {

    Optional<User> getUserByEmail(User user);
}
