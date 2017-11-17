package com.itcast.iraqishome.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.itcast.iraqishome.fragment.BaseFragment;

/**
 * 全部产品
 * Created by yb on 2017/11/14.
 */

public class ProductFragment extends BaseFragment{
    @Override
    public View initView() {
        TextView view = new TextView(mActivity);
        view.setText("ProductFragment");
        view.setTextSize(32);
        view.setGravity(Gravity.CENTER);
        return view;
    }

    @Override
    public void initData() {

    }
}
