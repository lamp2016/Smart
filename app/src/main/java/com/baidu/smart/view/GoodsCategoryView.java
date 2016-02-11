
package com.baidu.smart.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.baidu.smart.R;
import com.baidu.smart.model.ProductModel;

import org.xutils.x;

import java.util.List;

/**
 * 商品种类自定义(7个textview) Created by lishuai on 16/2/10.
 */
public class GoodsCategoryView extends LinearLayout {

    private Context mContext;

    public GoodsCategoryView(Context context) {
        super(context);
    }

    public GoodsCategoryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView() {
        View.inflate(mContext, R.layout.view_category_goods, this);
        x.view().inject(this);
    }

    public void setData(List<ProductModel> list) {

    }
}
