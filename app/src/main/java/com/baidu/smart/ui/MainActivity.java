
package com.baidu.smart.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Window;
import android.view.WindowManager;

import com.baidu.smart.R;
import com.baidu.smart.fragment.HomeFragment;
import com.baidu.smart.fragment.MenuLeftFragment;
import com.baidu.smart.utils.SystemBarTintManager;
import com.baidu.smart.view.TitleBarView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by lishuai on 16/1/29.
 */
public class MainActivity extends SlidingFragmentActivity {

    public static final String TAG = "MainActivity";

    private Fragment mContent;

    @ViewInject(R.id.titlebar)
    private TitleBarView mTitleBar;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        initView();
        initSlidingMenu(savedInstanceState);
    }

    private void initView() {
        // 沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }

        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.theme);// 通知栏所需颜色

        mTitleBar.setTitle(getString(R.string.app_name));
        mTitleBar.setTitleBarClickListener(new TitleBarView.TitleBarClickListener() {
            @Override
            public void leftClick() {
                toggle();
            }

            @Override
            public void rightClick() {

            }
        });
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new HomeFragment()).commit();
    }

    /**
     * 初始化侧边栏
     */
    private void initSlidingMenu(Bundle savedInstanceState) {
        // 如果保存的状态不为空则得到之前保存的Fragment，否则实例化MyFragment
        if (savedInstanceState != null) {
            mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
        }

        if (mContent == null) {
            mContent = new HomeFragment();
        }

        // 设置左侧滑动菜单
        setBehindContentView(R.layout.menu_frame_left);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.menu_frame, new MenuLeftFragment()).commit();

        // 实例化滑动菜单对象
        SlidingMenu sm = getSlidingMenu();
        // 设置可以左右滑动的菜单
        sm.setMode(SlidingMenu.LEFT);
        // 设置滑动阴影的宽度
        sm.setShadowWidthRes(R.dimen.shadow_width);
        // 设置滑动菜单阴影的图像资源
        sm.setShadowDrawable(null);
        // 设置滑动菜单视图的宽度
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        sm.setFadeDegree(0.35f);
        // 设置触摸屏幕的模式,这里设置为全屏
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        // 设置下方视图的在滚动时的缩放比例
        sm.setBehindScrollScale(0.0f);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "mContent", mContent);
    }

    /**
     * 切换Fragment
     *
     * @param fragment
     */
    public void switchConent(Fragment fragment) {
        mContent = fragment;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment).commit();
        getSlidingMenu().showContent();
    }

    /**
     * 沉浸式
     * 
     * @param on
     */
    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}
