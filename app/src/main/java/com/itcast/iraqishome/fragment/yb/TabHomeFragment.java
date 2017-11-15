package com.itcast.iraqishome.fragment.yb;

import android.view.LayoutInflater;
import android.view.View;

import com.itcast.iraqishome.R;
import com.itcast.iraqishome.fragment.BaseFragment;

import butterknife.ButterKnife;

/**
 * Tablayout-----首页
 * Created by yb on 2017/11/14.
 */

public class TabHomeFragment extends BaseFragment{
    @Override
    public View initView() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.fragment_tabhome, null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void initData() {
        getDataForServer();
    }

    private void getDataForServer() {

    }
}
