package com.baidu.smart.model;

import java.util.List;

/**
 * Created by baishixin on 16/2/19.
 */
public class MallIndexDataModel {

    private List<SlidesModel> slides;
    private List<ServiceModel> service;
    private List<CategoriesModel> categories;

    public MallIndexDataModel() {
    }

    public MallIndexDataModel(List<SlidesModel> slides, List<ServiceModel> service, List<CategoriesModel> categories) {
        this.slides = slides;
        this.service = service;
        this.categories = categories;
    }

    public List<SlidesModel> getSlides() {
        return slides;
    }

    public void setSlides(List<SlidesModel> slides) {
        this.slides = slides;
    }

    public List<ServiceModel> getService() {
        return service;
    }

    public void setService(List<ServiceModel> service) {
        this.service = service;
    }

    public List<CategoriesModel> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesModel> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "MallIndexDataModel{" +
                "slides=" + slides +
                ", service=" + service +
                ", categories=" + categories +
                '}';
    }
}
