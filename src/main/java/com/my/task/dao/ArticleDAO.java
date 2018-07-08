package com.my.task.dao;

import com.my.task.pojo.po.ArticlePO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ArticleDAO {

    @Select("SELECT * FROM article")
    List<ArticlePO> getAllArticles();

    @Insert("INSERT INTO article (title, url, allCharNum,chineseCharNum, englishCharNum, symbolCharNum) values " +
            "(#{title}, #{url}, #{allCharNum}, #{chineseCharNum} ,#{englishCharNum}, #{symbolCharNum})")
    void addArticle(ArticlePO article);
}
