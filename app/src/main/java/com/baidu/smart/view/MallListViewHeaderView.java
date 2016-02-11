package com.baidu.smart.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.baidu.smart.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * 商城首页整个ListView 头部Header 的自定义 View
 * Created by baishixin on 16/2/12.
 */
public class MallListViewHeaderView extends LinearLayout{

    private Context mContext;
    @ViewInject(R.id.riv_index_listview_header_rotation)
    private RotationImageView mRotatiionImageView;
    @ViewInject(R.id.ll_index_listview_service)
    private LinearLayout service;
    @ViewInject(R.id.ll_index_listview_header_category)
    private LinearLayout category;


    public MallListViewHeaderView(Context context) {
        super(context);
    }

    public MallListViewHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView() {
        View.inflate(mContext, R.layout.view_listview_header_top,this);
        x.view().inject(this);
    }

    public void setData(){

    }
}
