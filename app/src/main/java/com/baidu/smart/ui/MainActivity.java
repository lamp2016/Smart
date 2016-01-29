
package com.baidu.smart.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.baidu.smart.R;

/**
 * Created by lishuai on 16/1/29.
 */
public class MainActivity extends BaseActivity {

    public static final String TAG = "MainActivity";

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
