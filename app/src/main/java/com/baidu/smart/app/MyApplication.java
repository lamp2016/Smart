
package com.baidu.smart.app;

import android.app.Application;

import com.baidu.smart.BuildConfig;
import com.baidu.smart.net.okhttputils.OkHttpUtils;
import com.facebook.drawee.backends.pipeline.Fresco;

import org.xutils.x;

import okhttp3.OkHttpClient;

/**
 * Created by lishuai on 16/1/29.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        /// xutils
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);

        /// fresco
        Fresco.initialize(this);

        /// okhttp
        OkHttpClient client = OkHttpUtils.getInstance().getOkHttpClient();
        // client.setConnectTimeout(100000, TimeUnit.MILLISECONDS);
    }
}
