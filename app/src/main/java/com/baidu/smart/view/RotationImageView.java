package com.baidu.smart.view;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baidu.smart.R;
import com.baidu.smart.model.SlidesModel;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * 商城首页轮播图 自定义View
 * Created by baishixin on 16/2/11.
 */
public class RotationImageView extends FrameLayout implements ViewPager.OnPageChangeListener {

    private static final String TAG = "RotationImageView";
    private Context mContext;

    /**
     * ViewPager
     */
    @ViewInject(R.id.viewPager_index_header)
    private ViewPager viewPager;

    /**
     * 装点点的ImageView数组
     */
    private ImageView[] tips;

    /**
     * 装ImageView数组
     */
    private ImageView[] mImageViews;

    /**
     * 图片资源id
     */
    private int[] imgIdArray;
    @ViewInject(R.id.viewGroup_index_header)
    private ViewGroup group;


    public RotationImageView(Context context) {
        super(context);
    }

    public RotationImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView() {
        View.inflate(mContext, R.layout.view_custom_rotation, this);
        x.view().inject(this);
//        setData();
        tt();
    }

    public void tt(){
        //载入图片资源ID
        imgIdArray = new int[]{R.drawable.index_rotation1, R.drawable.index_rotation2, R.drawable.index_rotation3, R.drawable.index_rotation4,
                R.drawable.index_rotation5};


        //将点点加入到ViewGroup中
        tips = new ImageView[imgIdArray.length];
        for (int i = 0; i < tips.length; i++) {
            //设置每个小圆点的间隔为 6dp
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(6, 0, 0, 0);
            ImageView imageView = new ImageView(mContext);
            imageView.setLayoutParams(new LayoutParams(10, 10));
            tips[i] = imageView;
            if (i == 0) {
                tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
            } else {
                tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
            }

            group.addView(imageView, params);
        }


        //将图片装载到数组中
        mImageViews = new ImageView[imgIdArray.length];
        for (int i = 0; i < mImageViews.length; i++) {
            ImageView imageView = new ImageView(mContext);
            mImageViews[i] = imageView;
            imageView.setBackgroundResource(imgIdArray[i]);
        }

        //设置Adapter
        viewPager.setAdapter(new MyAdapter());
        //设置监听，主要是设置点点的背景
        viewPager.setOnPageChangeListener(this);
        //设置ViewPager的默认项, 设置为长度的100倍，这样子开始就能往左滑动
        viewPager.setCurrentItem((mImageViews.length) * 100);

        //activity启动两秒钟后，发送一个message，用来将viewPager中的图片切换到下一个
        mHandler.sendEmptyMessageDelayed(1, 2000);
    }

    public void setData(List<SlidesModel> slidesModels) {
        //载入图片资源ID
        imgIdArray = new int[]{R.drawable.index_rotation1, R.drawable.index_rotation2, R.drawable.index_rotation3, R.drawable.index_rotation4,
                R.drawable.index_rotation5};


        //将点点加入到ViewGroup中
        tips = new ImageView[slidesModels.size()];
        for (int i = 0; i < tips.length; i++) {
            //设置每个小圆点的间隔为 6dp
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(6, 0, 0, 0);
            ImageView imageView = new ImageView(mContext);
            imageView.setLayoutParams(new LayoutParams(10, 10));
            tips[i] = imageView;
            if (i == 0) {
                tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
            } else {
                tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
            }

            group.addView(imageView, params);
        }


        //将图片装载到数组中
        mImageViews = new ImageView[slidesModels.size()];
        for (int i = 0; i < mImageViews.length; i++) {
            ImageView imageView = new ImageView(mContext);
            mImageViews[i] = imageView;
            imageView.setImageURI(Uri.parse(slidesModels.get(i).getImg_url()));
//            imageView.setBackgroundResource(imgIdArray[i]);
        }

        //设置Adapter
        viewPager.setAdapter(new MyAdapter());
        //设置监听，主要是设置点点的背景
        viewPager.setOnPageChangeListener(this);
        //设置ViewPager的默认项, 设置为长度的100倍，这样子开始就能往左滑动
        viewPager.setCurrentItem((mImageViews.length) * 100);

        //activity启动两秒钟后，发送一个message，用来将viewPager中的图片切换到下一个
        mHandler.sendEmptyMessageDelayed(1, 2000);
    }

    public class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager) container).removeView(mImageViews[position % mImageViews.length]);

        }

        /**
         * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键
         */
        @Override
        public Object instantiateItem(View container, int position) {
            ((ViewPager) container).addView(mImageViews[position % mImageViews.length], 0);
            return mImageViews[position % mImageViews.length];
        }


    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
        setImageBackground(arg0 % mImageViews.length);
    }

    /**
     * 设置选中的tip的背景
     *
     * @param selectItems
     */
    private void setImageBackground(int selectItems) {
        for (int i = 0; i < tips.length; i++) {
            if (i == selectItems) {
                tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
            } else {
                tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
            }
        }
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:
                    int totalcount = mImageViews.length;//autoChangeViewPager.getChildCount();
                    int currentItem = viewPager.getCurrentItem();

                    int toItem = currentItem + 1 == totalcount ? 0 : currentItem + 1;

//                    Log.i(TAG, "totalcount: " + totalcount + "   currentItem: " + currentItem + "   toItem: " + toItem);

                    viewPager.setCurrentItem(toItem, true);

                    //每两秒钟发送一个message，用于切换viewPager中的图片
                    this.sendEmptyMessageDelayed(1, 2000);
            }
        }
    };

    
}
