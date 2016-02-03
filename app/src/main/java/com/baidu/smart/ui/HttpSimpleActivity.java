package com.baidu.smart.ui;

import android.os.Bundle;

import com.baidu.smart.net.okhttputils.OkHttpUtils;
import com.baidu.smart.net.okhttputils.callback.StringCallback;

import okhttp3.Call;

/**
 * 网络请求示例,勿删勿改,只做参照
 */
public class HttpSimpleActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        testRequest();

    }

    private void testRequest() {
        httpGet();
        
    }

    private void httpGet() {
        String url = "http://www.csdn.net/";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new StringCallback()
                {

                    @Override
                    public void onError(Call call, Exception e) {

                    }

                    @Override
                    public void onResponse(String response)
                    {

                    }
                });
    }
}
