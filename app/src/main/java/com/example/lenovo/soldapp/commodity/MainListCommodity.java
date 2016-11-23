package com.example.lenovo.soldapp.commodity;

import android.graphics.Bitmap;

/**
 * Created by lenovo on 2016/11/1.
 */
public class MainListCommodity {
    //用来存储网络上下载下来的图片
    //用来存储网络上下载下来的商品名字
    String tvAuthor;
    //用来存储网络上下载下来的商品简介
    String tvContent;
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MainListCommodity(Long id, String tvAuthor, String tvContent) {
        this.id=id;
        this.tvAuthor = tvAuthor;
        this.tvContent = tvContent;
    }

    public String getTvContent() {
        return tvContent;
    }

    public void setTvContent(String tvContent) {
        this.tvContent = tvContent;
    }

    public String getTvAuthor() {
        return tvAuthor;
    }

    public void setTvAuthor(String tvAuthor) {
        this.tvAuthor = tvAuthor;
    }


}
