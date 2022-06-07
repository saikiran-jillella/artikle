package com.saikiran.artikle.controller;

import com.saikiran.artikle.model.Article;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ArticleAssembler implements RepresentationModelAssembler<Article, EntityModel<Article>> {
    @Override
    public EntityModel<Article> toModel(Article article) {
        return EntityModel.of(article,
                linkTo(methodOn(ArticleController.class).getArticle(article.getArticleid())).withSelfRel());
    }
}
