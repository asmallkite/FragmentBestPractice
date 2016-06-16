package com.example.a10648.fragmentbestpractice;

/**
 * Created by 10648 on 2016/6/14 0014.
 */
public class News {
    private String title;
    private String content;
    int titleid;

    public News() {
    }

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getTitleid() {
        return titleid;
    }
    public News(String title, String content, int titleid) {
        this.title = title;
        this.content = content;
        this.titleid = titleid;
    }

    public void setTitleid(int titleid) {
        this.titleid = titleid;
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
