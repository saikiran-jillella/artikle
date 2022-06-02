package com.saikiran.artikle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;



@Entity
@Data
public class Article {
    @Id
    @GeneratedValue
    private Long articleid;
    @NotNull
    private Long userid;
    @NotNull
    private String title;
    @NotNull
    private String article;
}
