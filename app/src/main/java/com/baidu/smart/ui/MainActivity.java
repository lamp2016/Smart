
package com.baidu.smart.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;

import com.baidu.smart.R;
import com.baidu.third.xlistview.XListView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by lishuai on 16/1/29.
 */
public class MainActivity extends BaseActivity implements XListView.IXListViewListener {

    public static final String TAG = "MainActivity";

    private ArrayAdapter<String> mAdapter;

    private ArrayList<String> items = new ArrayList<>();

    private Handler mHandler;

    private int start = 0;

    private static int refreshCnt = 0;

    @ViewInject(R.id.xListView)
    XListView mListView;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        geneItems();

        mListView.setPullLoadEnable(true);
        mAdapter = new ArrayAdapter<>(this, R.layout.list_item, items);
        mListView.setAdapter(mAdapter);
        // mListView.setPullLoadEnable(false);
        // mListView.setPullRefreshEnable(false);
        mListView.setXListViewListener(this);
        mHandler = new Handler();
    }

    private void geneItems() {
        for (int i = 0; i != 20; ++i) {
            items.add("refresh cnt " + (++start));
        }
    }

    private void onLoad() {
        mListView.stopRefresh();
        mListView.stopLoadMore();
        mListView.setRefreshTime("刚刚");
    }

    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                start = ++refreshCnt;
                items.clear();
                geneItems();
                // mAdapter.notifyDataSetChanged();
                mAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.list_item, items);
                mListView.setAdapter(mAdapter);
                onLoad();
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                geneItems();
                mAdapter.notifyDataSetChanged();
                onLoad();
            }
        }, 2000);
    }
}
