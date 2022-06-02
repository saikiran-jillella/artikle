package com.saikiran.artikle.service;

import com.saikiran.artikle.crud.ArticleRepository;
import com.saikiran.artikle.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ArticleService implements IArticleService {


    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> getArticle(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public boolean createArticle(Article article) {
        if (getArticle(article.getArticleid()).isPresent()){
            return false;
        }
        articleRepository.save(article);
        return true;

    }

    @Override
    public boolean updateArticle(Article article,Long id) {
        if ( getArticle(id).isEmpty()){
            return false;
        }
        articleRepository.save(article);
        return true;
    }


}

