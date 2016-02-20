package com.baidu.smart.utils;

import com.baidu.smart.model.MallIndexDataModel;
import com.google.gson.Gson;

import org.json.JSONArray;

/**
 * Created by baishixin on 16/2/19.
 */
public class JsonToObjectUtils {
    public static final Gson gson = new Gson();
    public static MallIndexDataModel mallIndexDataModel = null;
    public static MallIndexDataModel getSlidesFromJson(String json) {
        JSONArray ja = new JSONArray();
//        ja.get
        mallIndexDataModel = gson.fromJson(json, MallIndexDataModel.class);
        System.out.println("mallIndexDataModel ==" + mallIndexDataModel);
        System.out.println("ServiceModel ==" + mallIndexDataModel.getService());
        System.out.println("CategoryModel ==" + mallIndexDataModel.getCategories());
        System.out.println("CustomsModel ==" + mallIndexDataModel.getCategories().get(0).getCustoms());

        return mallIndexDataModel;
    }
}
