package com.my.task.service;

import com.my.task.exception.DisposeArticleException;
import com.my.task.pojo.po.ArticlePO;

import java.util.List;

public interface ArticleServices{
    List<ArticlePO> getArticles();
    void disposeNewArticle(String url) throws DisposeArticleException;
    void addArticle(ArticlePO article);
}
