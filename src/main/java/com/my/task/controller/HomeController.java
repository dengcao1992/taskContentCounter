package com.my.task.controller;

import com.my.task.exception.DisposeArticleException;
import com.my.task.pojo.po.ArticlePO;
import com.my.task.service.ArticleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = {"", "/", "/index"})
public class HomeController {
    private static final String HOME = "home";
    private static final String SUCCESS = "成功";
    private static final String DISPOSE_NEW_ARTICLE_RESULT = "result";
    @Autowired
    private ArticleServices articleServices;

    @GetMapping
    public String getHome(Model model){
        List<ArticlePO> articles = articleServices.getArticles();
        model.addAttribute("articles", articles);
        return HOME;
    }

    @PostMapping
    public String postArticleUrl(@RequestParam String url, Model model){
        try {
            articleServices.disposeNewArticle(url);
        } catch (DisposeArticleException e){
            model.addAttribute(DISPOSE_NEW_ARTICLE_RESULT, e.getMessage());
            return getHome(model);
        }
        model.addAttribute(DISPOSE_NEW_ARTICLE_RESULT, SUCCESS);
        return getHome(model);
    }

    public ArticleServices getArticleServices() {
        return articleServices;
    }

    public void setArticleServices(ArticleServices articleServices) {
        this.articleServices = articleServices;
    }
}
