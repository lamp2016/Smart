package com.baidu.smart.model;

import java.util.List;

/**
 * Created by baishixin on 16/2/4.
 */
public class CategoriesModel {
    /**
     * 一级分类名
     */
    private String title;
    /**
     * 图标的url
     */
    private String img_url;
    /**
     * 服务跳转的地址
     */
    private String scheme;
    /**
     * 分类下的自定义button
     */
    private List<CustomsModel> customs;

    public CategoriesModel() {
    }

    public CategoriesModel(String title, String img_url, String scheme, List<CustomsModel> customs) {
        this.title = title;
        this.img_url = img_url;
        this.scheme = scheme;
        this.customs = customs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<CustomsModel> getCustoms() {
        return customs;
    }

    public void setCustoms(List<CustomsModel> customs) {
        this.customs = customs;
    }

    @Override
    public String toString() {
        return "CategoriesModel{" +
                "title='" + title + '\'' +
                ", img_url='" + img_url + '\'' +
                ", scheme='" + scheme + '\'' +
                ", customs=" + customs +
                '}';
    }
}
