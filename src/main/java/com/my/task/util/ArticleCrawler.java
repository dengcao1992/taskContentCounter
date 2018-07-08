package com.my.task.util;

import com.my.task.exception.DisposeArticleException;
import com.my.task.pojo.dto.ArticleDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;


public class ArticleCrawler {

    public ArticleDTO getArticleForUrl(String url) throws IOException, DisposeArticleException {
//        if (url.equals("")){
//            throw new DisposeArticleException("url不能为空");
//        }
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setUrl(url);
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            throw new DisposeArticleException("url有误");
        }
        Element bodyElement = document.body();
        articleDTO.setTitle(document.title());
        articleDTO.setHttpLines(bodyElement.text());
        return articleDTO;
    }


}
