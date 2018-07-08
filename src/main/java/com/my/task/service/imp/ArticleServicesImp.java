package com.my.task.service.imp;

import com.my.task.constant.ArticleConstant;
import com.my.task.dao.ArticleDAO;
import com.my.task.exception.DisposeArticleException;
import com.my.task.pojo.dto.ArticleDTO;
import com.my.task.pojo.po.ArticlePO;
import com.my.task.service.ArticleServices;
import com.my.task.util.ArticleCrawler;
import com.my.task.util.ArticleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServicesImp implements ArticleServices{
    @Autowired
    private ArticleDAO articleDAO;

    @Override
    public List<ArticlePO> getArticles() {
        return articleDAO.getAllArticles();
    }

    @Override
    public void addArticle(ArticlePO article) {
        articleDAO.addArticle(article);
    }

    @Override
    public void disposeNewArticle(String url) throws DisposeArticleException{
        ArticleCrawler webCrawler = new ArticleCrawler();
        ArticleDTO newArticle = null;
        try {
            newArticle = webCrawler.getArticleForUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,Integer> articleCharNum = ArticleUtils.getArticleCharNum(newArticle);
        int allNum = articleCharNum.get(ArticleConstant.CHAR_NUM_OF_ALL);
        int chineseNum = articleCharNum.get(ArticleConstant.CHAR_NUM_OF_CHINESE);
        int englishNum = articleCharNum.get(ArticleConstant.CHAR_NUM_OF_ENGLISH);
        int symbolNum = articleCharNum.get(ArticleConstant.CHAR_NUM_OF_SYMBOL);
        ArticlePO article = new ArticlePO(newArticle.getTitle(), newArticle.getUrl(), allNum, chineseNum, englishNum, symbolNum);
        addArticle(article);
    }

    public ArticleDAO getArticleDAO() {
        return articleDAO;
    }

    public void setArticleDAO(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }
}
