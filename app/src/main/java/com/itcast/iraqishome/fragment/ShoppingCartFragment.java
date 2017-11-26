package com.itcast.iraqishome.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.itcast.iraqishome.MainActivity;
import com.itcast.iraqishome.R;
import com.itcast.iraqishome.utills.UIUtils;
import com.itcast.iraqishome.view.NoScrollViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 购物车
 * Created by yb on 2017/11/14.
 */

public class ShoppingCartFragment extends BaseFragment{
    @BindView(R.id.tv_toolbar_title) TextView tvToolbarTitle;
    @BindView(R.id.iv_toolbar_category)ImageView ivToolbarCategory;
    @BindView(R.id.iv_toolbar_back) ImageView ivToolbarBack;
    @BindView(R.id.recycler_shop) RecyclerView mRecyclerView;
    @BindView(R.id.iv_shop_icon)ImageView ivShopIcon;
    @BindView(R.id.tv_shop_des) TextView tvShopDes;
    @BindView(R.id.btn_shop_stroll) Button btnShopStroll;
    private MainActivity activity;

    @Override
    public View initView() {
        View view = LayoutInflater.from(UIUtils.getContext()).inflate(R.layout.fragment_shoppingcart, null);
        initBasic(view);
        return view;
    }

    private void initBasic(View view) {
        ButterKnife.bind(this,view);
        tvToolbarTitle.setText("购物车");
        ivToolbarCategory.setVisibility(View.GONE);
        ivToolbarBack.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.iv_toolbar_back)
    public void backPreActivity(){
        activity = (MainActivity)mActivity;
        NoScrollViewPager viewPager = activity.getViewPager();
        int currentItem = viewPager.getCurrentItem();
        currentItem--;
        viewPager.setCurrentItem(currentItem);
    }

    @Override
    public void initData() {

    }


}
