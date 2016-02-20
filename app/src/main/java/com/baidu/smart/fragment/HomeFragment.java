
package com.baidu.smart.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.baidu.smart.R;
import com.baidu.smart.app.MyApplication;
import com.baidu.smart.app.OnTouchListener;
import com.baidu.smart.model.MallIndexDataModel;
import com.baidu.smart.net.okhttputils.OkHttpUtils;
import com.baidu.smart.net.okhttputils.callback.StringCallback;
import com.baidu.smart.utils.JsonToObjectUtils;
import com.baidu.smart.view.IndexFloatView;
import com.baidu.smart.view.MallListViewHeaderView;
import com.baidu.smart.view.MallProductView;
import com.baidu.third.xlistview.XListView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

import okhttp3.Call;

/**
 * 主页fragment Created by lishuai on 16/2/3.
 */
public class HomeFragment extends BaseFragment implements XListView.IXListViewListener, AdapterView.OnItemClickListener, OnTouchListener {
    public static final String TAG = "HomeFragment";
    private Context mContext;

    @ViewInject(R.id.che)
    private IndexFloatView che;
    @ViewInject(R.id.xlv_index_productlist)
    private XListView mListView;
    private MyAdapter mAdapter;
    private ArrayList<String> items = new ArrayList<String>();
    private Handler mHandler;
    private int start = 0;
    private static int refreshCnt = 0;

    private LayoutInflater mInflater;
    private View view = null;
    public static MallIndexDataModel mallIndexDataModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mInflater = inflater;
        view = inflater.inflate(R.layout.activity_home, container, false);
        x.view().inject(this, view);
        geneItems();
        initData();
//        initView(view);


        return view;
    }


    /**
     * 初始化数据
     */
    private void initData() {
        OkHttpUtils
                .get()
                .url(MyApplication.MALL_INDEX)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        mallIndexDataModel = JsonToObjectUtils.getSlidesFromJson(response);
                        System.out.println("mallIndexDataModel == " + mallIndexDataModel == null);
                        initView(view);
                    }
                });
    }

    /**
     * 初始化视图
     *
     * @param view
     */
    private void initView(View view) {
        MallListViewHeaderView v = new MallListViewHeaderView(mContext);
        v.setData(mallIndexDataModel);
        mListView.addHeaderView(v);

        mListView.setPullLoadEnable(true);
        mAdapter = new MyAdapter();
        mListView.setAdapter(mAdapter);
        mListView.setXListViewListener(this);
        mListView.setOnItemClickListener(this);
        mHandler = new Handler();
        che.setOnTouchListener(this);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void geneItems() {
        for (int i = 0; i != 20; ++i) {
            items.add("商品 " + (++start));
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
                mAdapter = new MyAdapter();
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onTouchEvent(View v, MotionEvent event) {
        if (v.getId() == R.id.che) {
            Toast.makeText(mContext,
                    "haha:" + v.getId() + ":" + event.getX() + ":"
                            + event.getY(),
                    Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    class MyAdapter extends BaseAdapter {

        private int ratio = 0;
        private int increase = 0;


        @Override
        public int getCount() {
            if (items.size() % 2 == 0) return items.size() / 2;
            else return items.size() / 2 + 1;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        /**
         * ListView 双列显示，实现思路，左边放偶数下标，右边放奇数下标
         * 0              1
         * 2              3
         * 4              5
         * 6              7
         * .              .
         * .              .
         * 10             11
         * 20             21
         * (position*2)    (position*2+1)
         *
         * @param position
         * @param convertView
         * @param parent
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder vh = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.layout_index_listview_item, null);
                vh = new ViewHolder();
                vh.mpv1 = (MallProductView) convertView.findViewById(R.id.mpv_list_item1);
                vh.mpv2 = (MallProductView) convertView.findViewById(R.id.mpv_list_item2);
                convertView.setTag(vh);
            }
            vh = (ViewHolder) convertView.getTag();
            vh.mpv1.setData(items.get(position * 2));
            if (!(items.size() % 2 != 0 && position == (items.size() / 2 + 1)))
                vh.mpv2.setData(items.get(position * 2 + 1));
            return convertView;
        }
    }

    class ViewHolder {
        MallProductView mpv1;
        MallProductView mpv2;
    }

}











