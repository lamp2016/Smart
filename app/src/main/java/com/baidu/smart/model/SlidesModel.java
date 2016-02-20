package com.baidu.smart.model;

/**
 * Created by baishixin on 16/2/4.
 */
public class SlidesModel {
    private String img_url;//轮播图地址
    private String scheme;//点击跳转地址

    public SlidesModel() {
    }

    public SlidesModel(String img_url, String scheme) {
        this.img_url = img_url;
        this.scheme = scheme;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @Override
    public String toString() {
        return "SlidesModel{" +
                "img_url='" + img_url + '\'' +
                ", scheme='" + scheme + '\'' +
                '}';
    }
}
