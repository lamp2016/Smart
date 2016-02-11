package com.baidu.smart.model;

/**
 * Created by baishixin on 16/2/12.
 */
public class RotationImageModel {

    private String img_url;//轮播图url
    private String scheme;//轮播图跳转地址

    public RotationImageModel() {
    }

    public RotationImageModel(String img_url, String scheme) {
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
        return "RotationImageModel{" +
                "img_url='" + img_url + '\'' +
                ", scheme='" + scheme + '\'' +
                '}';
    }
}
