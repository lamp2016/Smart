
package com.baidu.smart.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.smart.R;

/**
 * Created by lishuai on 16/2/3.
 */
public class MenuLeftFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_menu, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

    }
}
