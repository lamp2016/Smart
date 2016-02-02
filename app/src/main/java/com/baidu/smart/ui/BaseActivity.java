
package com.baidu.smart.ui;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by lishuai on 16/1/29.
 */
public class BaseActivity extends Activity {
    // public WindowManager mWindowManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // x.view().inject(this);
        // 沉浸式状态栏
        // mWindowManager =
        // (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        // AppUtils.setImmersionType(this);

    }

}
