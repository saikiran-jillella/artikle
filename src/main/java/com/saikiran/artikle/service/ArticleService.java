package com.saikiran.artikle.service;

import com.saikiran.artikle.model.Article;
import com.saikiran.artikle.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ArticleService implements IArticleService {


    private final ArticleRepository articleRepository;


    @Override
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> getArticle(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);

    }


    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

}

