package com.saikiran.artikle.service;

import com.saikiran.artikle.model.User;

import java.util.Optional;

public interface IUserHandler {
    Optional<User> getUser(Long id);
}
