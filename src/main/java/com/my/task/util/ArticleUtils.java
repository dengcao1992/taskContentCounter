package com.my.task.util;

import com.my.task.constant.ArticleConstant;
import com.my.task.pojo.dto.ArticleDTO;
import java.util.HashMap;
import java.util.Map;

public class ArticleUtils {
    public static Map<String,Integer> getArticleCharNum(ArticleDTO article){
        int MAP_INIT_SIZE = 4;
        int allNum = 0;
        int chineseNum = 0;
        int englishNum = 0;
        int symbolNum = 0;
        Map<String,Integer> result = new HashMap<>(MAP_INIT_SIZE);
        String httpLines = article.getHttpLines();
        String[] httpLinesArray = httpLines.split("");
        for (String oneChar : httpLinesArray){
            if (oneChar.matches("\\s")){
                continue;
            }
            allNum ++;
            if (oneChar.matches("[a-zA-Z\\d]")){
                englishNum ++;
                continue;
            }
            if (oneChar.matches("[\\u4e00-\\u9fa5]")){
                chineseNum ++;
                continue;
            }
            if (oneChar.matches("[\\pP\\pS]")){
                symbolNum ++;
                continue;
            }
        }
        result.put(ArticleConstant.CHAR_NUM_OF_ALL,allNum);
        result.put(ArticleConstant.CHAR_NUM_OF_CHINESE,chineseNum);
        result.put(ArticleConstant.CHAR_NUM_OF_ENGLISH,englishNum);
        result.put(ArticleConstant.CHAR_NUM_OF_SYMBOL,symbolNum);
        return result;
    }

}
