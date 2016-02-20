package com.baidu.smart.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.baidu.smart.view.MallListViewHeaderView;

/**
 * 用来测试自定义布局的Activity 没有用
 * Created by baishixin on 16/2/18.
 */
public class TestActivity extends BaseActivity{


    public static void start(Context context){
        Intent intent = new Intent(context, TestActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MallListViewHeaderView mv = new MallListViewHeaderView(this);
        this.setContentView(mv);
//        setContentView(R.layout.view_listview_header_top);
//        setContentView(new MallListViewHeaderView(this));
    }
}
