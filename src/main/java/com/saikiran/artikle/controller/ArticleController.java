package com.saikiran.artikle.controller;


import com.saikiran.artikle.model.Article;
import com.saikiran.artikle.service.ArticleService;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/v1/article")
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleAssembler articleAssembler;


    @GetMapping("/all")
    public CollectionModel<EntityModel<Article>> getArticles() {
        List<EntityModel<Article>> articles = articleService.getArticles().stream().map(articleAssembler::toModel).toList();
        return CollectionModel.of(articles, linkTo(methodOn(ArticleController.class).getArticles()).withSelfRel());
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<?> getArticle(@PathVariable Long id) {
        Optional<?> article = articleService.getArticle(id);
        if (article.isPresent()) {
            return ResponseEntity.ok(article);
        } else {
            JSONObject json = new JSONObject();
            json.put("error", String.format("No article found with id: %d", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EntityModel<Article> createArticle(@RequestBody Article article) {
        return articleAssembler.toModel(articleService.createArticle(article));
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateArticle(@RequestBody Article newArticle, @PathVariable Long id) {

        Optional<Article> updatedArticle = articleService.getArticle(id) //
                .map(article -> {
                    article.setTitle(newArticle.getTitle());
                    article.setArticle(newArticle.getArticle());
                    return articleService.createArticle(article);
                });
        if (updatedArticle.isPresent()) {
            return ResponseEntity.ok(updatedArticle);
        } else {
            JSONObject json = new JSONObject();
            json.put("error", String.format("No article found with id: %d", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
        }

    }

    @DeleteMapping("/{id}")
    void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}
