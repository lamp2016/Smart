
package com.baidu.smart.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.smart.R;
import com.baidu.smart.model.CategoriesModel;
import com.baidu.smart.model.CustomsModel;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * 商品种类自定义(7个textview) Created by lishuai on 16/2/10.
 */
public class GoodsCategoryView extends LinearLayout {

    private Context mContext;

    @ViewInject(R.id.tv_index_header_categorytitle)
    private TextView mTextView_categoryTitle;
    @ViewInject(R.id.tv_index_header_producttitle1)
    private TextView mTextView_productTitle1;
    @ViewInject(R.id.tv_index_header_producttitle2)
    private TextView mTextView_productTitle2;
    @ViewInject(R.id.tv_index_header_producttitle3)
    private TextView mTextView_productTitle3;
    @ViewInject(R.id.tv_index_header_producttitle4)
    private TextView mTextView_productTitle4;
    @ViewInject(R.id.tv_index_header_producttitle5)
    private TextView mTextView_productTitle5;
    @ViewInject(R.id.tv_index_header_producttitle5)
    private TextView mTextView_productTitle6;

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

    public void setData(CategoriesModel categoriesModel) {
        mTextView_categoryTitle.setText(categoriesModel.getTitle());
        List<CustomsModel> customsModels = categoriesModel.getCustomsModelList();
        CustomsModel customsModel = null;
        for (int i = 0; i < 6; i++) {
            customsModel = customsModels.get(i);
            if (customsModel != null) {
                switch (i) {
                    case 0:
                        if(customsModel.getTitle()!=null){

                        }
                        break;
                    case 1:
                        mTextView_productTitle2.setVisibility(INVISIBLE);
                        break;
                    case 2:
                        mTextView_productTitle3.setVisibility(INVISIBLE);
                        break;
                    case 3:
                        mTextView_productTitle4.setVisibility(INVISIBLE);
                        break;
                    case 4:
                        mTextView_productTitle5.setVisibility(INVISIBLE);
                        break;
                    case 5:
                        mTextView_productTitle6.setVisibility(INVISIBLE);
                        break;
                }
            } else {
                switch (i) {
                    case 0:
                        mTextView_productTitle1.setVisibility(INVISIBLE);
                        break;
                    case 1:
                        mTextView_productTitle2.setVisibility(INVISIBLE);
                        break;
                    case 2:
                        mTextView_productTitle3.setVisibility(INVISIBLE);
                        break;
                    case 3:
                        mTextView_productTitle4.setVisibility(INVISIBLE);
                        break;
                    case 4:
                        mTextView_productTitle5.setVisibility(INVISIBLE);
                        break;
                    case 5:
                        mTextView_productTitle6.setVisibility(INVISIBLE);
                        break;
                }
            }

        }
    }
}
