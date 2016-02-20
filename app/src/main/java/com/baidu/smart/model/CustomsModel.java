package com.baidu.smart.model;

/**
 * Created by baishixin on 16/2/4.
 */
public class CustomsModel {
    /**
     * button标题，这里存在三种情况，只有文字、只有图标和文字+图标
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

    public CustomsModel() {
    }

    public CustomsModel(String title, String img_url, String scheme) {
        this.title = title;
        this.img_url = img_url;
        this.scheme = scheme;
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

    @Override
    public String toString() {
        return "CustomsModel{" +
                "title='" + title + '\'' +
                ", img_url='" + img_url + '\'' +
                ", scheme='" + scheme + '\'' +
                '}';
    }
}
