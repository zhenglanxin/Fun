package com.example.lenovo.soldapp.commodity;

import android.graphics.Bitmap;

/**
 * Created by lenovo on 2016/11/3.
 */
public class RecommendListCommodity {
    private String name;
    private String synopsis;
    private Long id;

    public RecommendListCommodity(Long id,String name, String synopsis) {
        this.id=id;
        this.name = name;
        this.synopsis = synopsis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
