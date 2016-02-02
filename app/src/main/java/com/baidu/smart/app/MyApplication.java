
package com.baidu.smart.app;

import android.app.Application;

import com.baidu.smart.BuildConfig;

import org.xutils.x;

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
        // xutils
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
