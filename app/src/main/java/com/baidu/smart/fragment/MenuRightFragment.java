
package com.baidu.smart.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lishuai on 16/2/3.
 */
public class MenuRightFragment extends BaseFragment {
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        if (mView == null) {
//            mView = inflater.inflate(R.layout.right_menu, container, false);
        }
        return mView;
    }
}
