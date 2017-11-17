package com.itcast.iraqishome.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.itcast.iraqishome.fragment.BaseFragment;

/**
 * 账户中心
 * Created by yb on 2017/11/14.
 */

public class CenterFragment extends BaseFragment{
    @Override
    public View initView() {
        TextView view = new TextView(mActivity);
        view.setText("CenterFragment");
        view.setTextSize(32);
        view.setGravity(Gravity.CENTER);
        return view;
    }

    @Override
    public void initData() {

    }
}
