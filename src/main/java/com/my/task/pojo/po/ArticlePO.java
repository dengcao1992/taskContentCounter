package com.my.task.pojo.po;

public class ArticlePO {
    public long aID;
    public String title;
    public String url;
    public int allCharNum;
    public int chineseCharNum;
    public int englishCharNum;
    public int symbolCharNum;

    public ArticlePO(){
        super();
    }

    public ArticlePO(String title, String url, int allCharNum, int chineseCharNum, int englishCharNum, int symbolCharNum){
        super();
        this.title = title;
        this.url = url;
        this.allCharNum = allCharNum;
        this.chineseCharNum = chineseCharNum;
        this.englishCharNum = englishCharNum;
        this.symbolCharNum = symbolCharNum;
    }

    public long getaID() {
        return aID;
    }

    public void setaID(long aID) {
        this.aID = aID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAllCharNum() {
        return allCharNum;
    }

    public void setAllCharNum(int allCharNum) {
        this.allCharNum = allCharNum;
    }

    public int getChineseCharNum() {
        return chineseCharNum;
    }

    public void setChineseCharNum(int chineseCharNum) {
        this.chineseCharNum = chineseCharNum;
    }

    public int getEnglishCharNum() {
        return englishCharNum;
    }

    public void setEnglishCharNum(int englishCharNum) {
        this.englishCharNum = englishCharNum;
    }

    public int getSymbolCharNum() {
        return symbolCharNum;
    }

    public void setSymbolCharNum(int symbolCharNum) {
        this.symbolCharNum = symbolCharNum;
    }
}
