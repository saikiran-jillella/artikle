package com.saikiran.artikle.crud;

import com.saikiran.artikle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}