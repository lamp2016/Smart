package com.baidu.smart.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.baidu.smart.R;

import org.xutils.x;

/**
 * 商城首页右下角漂浮的自定义View
 * Created by baishixin on 16/2/19.
 */
public class IndexFloatView extends ImageView implements ViewTreeObserver.OnGlobalLayoutListener {

    private int radius = 0;

    private RectF rectF = null;

    private Context mContext;

    private com.baidu.smart.app.OnTouchListener mOnTouchListener = null;

    public IndexFloatView(Context context) {
        super(context);
        TypedArray ta = context.obtainStyledAttributes(R.styleable.IndexFloatView);
        radius = ta.getDimensionPixelSize(R.styleable.IndexFloatView_radius, 0);
        rectF = new RectF(0, 0, 2 * radius, 2 * radius);
        ta.recycle();

        ViewTreeObserver vto = getViewTreeObserver();
        vto.addOnGlobalLayoutListener(this);
    }

    public IndexFloatView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.IndexFloatView);
        radius = ta.getDimensionPixelSize(R.styleable.IndexFloatView_radius, 0);
        rectF = new RectF(0, 0, 2 * radius, 2 * radius);
        ta.recycle();

        ViewTreeObserver vto = getViewTreeObserver();
        vto.addOnGlobalLayoutListener(this);
//        initView();
    }

    private void initView() {
        View.inflate(mContext, R.layout.view_index_floatview, null);
        x.view().inject(this);
    }

    public IndexFloatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.IndexFloatView);
        radius = ta.getDimensionPixelSize(R.styleable.IndexFloatView_radius, 0);
        rectF = new RectF(0, 0, 2 * radius, 2 * radius);
        ta.recycle();

        ViewTreeObserver vto = getViewTreeObserver();
        vto.addOnGlobalLayoutListener(this);
//        initView();
    }

    public void setOnTouchListener(com.baidu.smart.app.OnTouchListener mOnTouchListener) {
        this.mOnTouchListener = mOnTouchListener;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        p.reset();
        p.setARGB(191, 0, 0, 0);
        canvas.drawRoundRect(rectF, radius, radius, p);
        super.onDraw(canvas);
    }

    @Override
    public void onGlobalLayout() {
        ViewGroup.LayoutParams lp = getLayoutParams();
        lp.height = 2 * radius;
        lp.width = 2 * radius;
        setLayoutParams(lp);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        if ((x - radius) * (x - radius) + (y - radius) * (y - radius) < radius * radius) {
            Log.d("nei", "" + x + ":" + y);
            return mOnTouchListener.onTouchEvent(this, event);
        } else {
            Log.d("wai", "" + x + ":" + y);
            return false;
        }
    }
}
