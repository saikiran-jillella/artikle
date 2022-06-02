package com.saikiran.artikle.controller;


import com.saikiran.artikle.model.Article;
import com.saikiran.artikle.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/article")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleFetcher) {
        this.articleService = articleFetcher;
    }

    @GetMapping("/all")
    public List<Article> getArticles() {
        return articleService.getArticles();
    }

    @GetMapping("/{id}")
    public Optional<Article> getArticle(@PathVariable Long id) {
        return articleService.getArticle(id);
    }

    @PostMapping
    public boolean createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    @PutMapping("/{id}")
    public boolean updateArticle(@RequestBody Article article, @PathVariable Long id) {
        return articleService.updateArticle(article, id);
    }


}
