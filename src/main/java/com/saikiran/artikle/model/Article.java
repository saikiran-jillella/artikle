package com.saikiran.artikle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Article article = (Article) o;
        return articleid != null && Objects.equals(articleid, article.articleid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
