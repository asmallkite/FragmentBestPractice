package com.example.a10648.fragmentbestpractice.model;

/**
 * Created by 10648 on 2016/6/14 0014.
 */
public class News {
    int titleId;
    private String title;
    private String content;


    public News() {
    }

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }



    public News(int titleid, String title, String content) {
        this.titleId = titleid;
        this.title = title;
        this.content = content;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
