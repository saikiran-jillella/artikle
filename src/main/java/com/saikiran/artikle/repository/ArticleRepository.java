package com.saikiran.artikle.repository;

import com.saikiran.artikle.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
