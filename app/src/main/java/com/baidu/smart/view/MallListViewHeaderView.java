package com.baidu.smart.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.baidu.smart.R;
import com.baidu.smart.model.CategoriesModel;
import com.baidu.smart.model.MallIndexDataModel;
import com.baidu.smart.model.ServiceModel;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * 商城首页整个ListView 头部Header 的自定义 View
 * Created by baishixin on 16/2/12.
 */
public class MallListViewHeaderView extends LinearLayout {

    private Context mContext;
    @ViewInject(R.id.riv_index_listview_header_rotation)
    private RotationImageView mRotatiionImageView;
    @ViewInject(R.id.ll_index_listview_service)
    private LinearLayout service;
    @ViewInject(R.id.ll_index_listview_header_category)
    private LinearLayout category;


    public MallListViewHeaderView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public MallListViewHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void initView() {
        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = mInflater.inflate(R.layout.view_listview_header_top, null);
        this.addView(v);
        x.view().inject(this);
    }

    public void setData(MallIndexDataModel mallIndexDataModel) {
//        if (mallIndexDataModel.getSlides().size() != 0) {
//            mRotatiionImageView.setData(mallIndexDataModel.getSlides());
//        }
        List<ServiceModel> serviceModels = mallIndexDataModel.getService();
        LayoutParams params = new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        for (ServiceModel s : serviceModels) {
            MallServiceView msv = new MallServiceView(mContext);
            msv.setData(s);
            service.addView(msv, params);
        }

        List<CategoriesModel> categoriesModels = mallIndexDataModel.getCategories();
        for (CategoriesModel c : categoriesModels) {
            GoodsCategoryView gcv = new GoodsCategoryView(mContext);
            gcv.setData(c);
            category.addView(gcv);
        }
    }
}
