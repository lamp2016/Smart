package com.baidu.smart.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.smart.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by baishixin on 16/2/11.
 */
public class MallProductView extends LinearLayout implements View.OnTouchListener{

    private Context mContext;

    @ViewInject(R.id.list_item_textview)
    private TextView mTextView;

    public MallProductView(Context context) {
        super(context);

    }

    public MallProductView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = mInflater.inflate(R.layout.list_item, null);
        this.addView(v);
        x.view().inject(this);
        mTextView.setOnTouchListener(this);
    }

    public void setData(String title) {
        mTextView.setText(title);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Toast.makeText(mContext,mTextView.getText().toString(),Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

//    @Override
//    public void onClick(View v) {
//        Toast.makeText(mContext,mTextView.getText().toString(),Toast.LENGTH_SHORT).show();
//    }


}
