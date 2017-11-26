package com.itcast.iraqishome.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.itcast.iraqishome.R;
import com.itcast.iraqishome.utills.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 账户中心
 * Created by yb on 2017/11/14.
 */

public class CenterFragment extends BaseFragment{
    @BindView(R.id.tv_toolbar_title) TextView tvToolbarTitle;
    @BindView(R.id.iv_toolbar_category)ImageView ivToolbarCategory;
    @BindView(R.id.tv_toolbar_setting)TextView tvToolbarSetting;

    @Override
    public View initView() {
        View view = LayoutInflater.from(UIUtils.getContext()).inflate(R.layout.fragment_center, null);
        initBasic(view);
        return view;
    }

    private void initBasic(View view) {
        ButterKnife.bind(this,view);
        tvToolbarTitle.setText("账户中心");
        ivToolbarCategory.setVisibility(View.GONE);
        tvToolbarSetting.setVisibility(View.VISIBLE);
    }

    @Override
    public void initData() {

    }
}
