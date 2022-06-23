package com.saikiran.artikle.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
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
//    @ManyToOne
//    @JoinColumn(name='User')
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
