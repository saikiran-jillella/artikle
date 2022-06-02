package com.saikiran.artikle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long userid;
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;
}
