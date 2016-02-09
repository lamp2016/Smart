
package com.baidu.smart.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.baidu.smart.R;

/**
 * 引导页 Created by lishuai on 16/1/29.
 */
public class SplashActivity extends BaseActivity {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        MainActivity.start(SplashActivity.this);

        finish();
    }
}
