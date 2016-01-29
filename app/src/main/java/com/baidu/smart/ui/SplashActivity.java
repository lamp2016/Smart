
package com.baidu.smart.ui;

import android.os.Bundle;

import com.baidu.smart.R;

/**
 * 引导页 Created by lishuai on 16/1/29.
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        MainActivity.start(SplashActivity.this);
        finish();
    }
}
