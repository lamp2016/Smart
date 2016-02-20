
package com.baidu.smart.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.smart.R;
import com.baidu.smart.model.CategoriesModel;
import com.baidu.smart.model.CustomsModel;
import com.baidu.smart.net.okhttputils.OkHttpUtils;
import com.baidu.smart.net.okhttputils.callback.BitmapCallback;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

import okhttp3.Call;

/**
 * 商品种类自定义(7个textview) Created by lishuai on 16/2/10.
 */
public class GoodsCategoryView extends LinearLayout implements View.OnClickListener {

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
    @ViewInject(R.id.tv_index_header_producttitle6)
    private TextView mTextView_productTitle6;

    public GoodsCategoryView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public GoodsCategoryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView() {
        View.inflate(mContext, R.layout.view_category_goods, this);
        x.view().inject(this);
        mTextView_categoryTitle.setOnClickListener(this);
    }

    public void setData(CategoriesModel categoriesModel) {
        mTextView_categoryTitle.setText(categoriesModel.getTitle());
        OkHttpUtils
                .get()//
                .url(categoriesModel.getImg_url())//
                .build()//
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e) {

                    }

                    @Override
                    public void onResponse(Bitmap response) {
                        BitmapDrawable drawable = new BitmapDrawable(getResources(), response);
                        //这一步必须做，不然图片不会显示，现在还不知道为什么。
                        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                        mTextView_categoryTitle.setCompoundDrawables(null, drawable, null, null);
                    }
                });


        List<CustomsModel> customsModels = categoriesModel.getCustoms();

        CustomsModel customsModel = null;
        for (int i = 0; i < 6; i++) {
            System.out.println("i ==== " + i);
            if (i < customsModels.size()) {
                customsModel = customsModels.get(i);
                System.out.println("customsModel ==== " + customsModel);

            }
            if (customsModel != null) {
                switch (i) {
                    case 0:
                        set(mTextView_productTitle1, customsModel);
                        break;
                    case 1:
                        set(mTextView_productTitle2, customsModel);
                        break;
                    case 2:
                        set(mTextView_productTitle3, customsModel);
                        break;
                    case 3:
                        set(mTextView_productTitle4, customsModel);
                        break;
                    case 4:
                        set(mTextView_productTitle5, customsModel);
                        break;
                    case 5:
                        set(mTextView_productTitle6, customsModel);
                        break;
                }
            }
            customsModel = null;
        }
    }

    private void set(final TextView id, CustomsModel customsModel) {
        final String title = customsModel.getTitle();
        System.out.println("title == " + title);
        System.out.println("url == " + customsModel.getImg_url());
        System.out.println("----------------------------");
        if (title != null && !"".equals(title)) {
            id.setText(title);
        } else {
//            id.setText("");
//            id.setVisibility(View.INVISIBLE);
        }
        if (customsModel.getImg_url() != null && !"".equals(customsModel.getImg_url())) {
            OkHttpUtils
                    .get()//
                    .url(customsModel.getImg_url())//
                    .build()//
                    .execute(new BitmapCallback() {
                        @Override
                        public void onError(Call call, Exception e) {

                        }

                        @Override
                        public void onResponse(Bitmap response) {
                            BitmapDrawable drawable = new BitmapDrawable(getResources(), response);
                            //这一步必须做，不然图片不会显示，现在还不知道为什么。
                            if (title == null || "".equals(title)) {
                                drawable.setBounds(0, 0, 50, 50);

                            } else {
                                drawable.setBounds(0, 0, 36, 36);
                            }
                            id.setCompoundDrawables(drawable, null, null, null);
                        }
                    });
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_index_header_categorytitle:
                Toast.makeText(mContext, mTextView_categoryTitle.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
