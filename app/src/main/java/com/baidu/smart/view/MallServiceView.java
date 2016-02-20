package com.baidu.smart.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.smart.R;
import com.baidu.smart.model.ServiceModel;
import com.baidu.smart.net.okhttputils.OkHttpUtils;
import com.baidu.smart.net.okhttputils.callback.BitmapCallback;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import okhttp3.Call;

/**
 * Created by baishixin on 16/2/10.
 */
public class MallServiceView extends LinearLayout {

    private Context mContext;

    @ViewInject(R.id.iv_index_header_service)
    private ImageView mImageView_headerService;
    @ViewInject(R.id.tv_index_header_serviceTitle)
    private TextView mTextView_header_ServiceTitle;

    public MallServiceView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public MallServiceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView() {
        View v = View.inflate(mContext, R.layout.view_category_service, this);
        x.view().inject(this,v);
    }

    public void setData(ServiceModel serviceModel) {
        OkHttpUtils
                .get()//
                .url(serviceModel.getImg_url())//
                .build()//
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e) {

                    }

                    @Override
                    public void onResponse(Bitmap response) {
                        mImageView_headerService.setImageBitmap(response);
                    }
                });
//        mImageView_headerService.setImageURI(Uri.parse(serviceModel.getImg_url()));
        mTextView_header_ServiceTitle.setText(serviceModel.getTitle());
    }
}
