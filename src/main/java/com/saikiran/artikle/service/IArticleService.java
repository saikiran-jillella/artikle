package com.saikiran.artikle.service;

import com.saikiran.artikle.model.Article;

import java.util.List;
import java.util.Optional;

public interface IArticleService {
    List<Article> getArticles();

    Optional<Article> getArticle(Long id);

    Article createArticle(Article article);

    void deleteArticle(Long id);
}
