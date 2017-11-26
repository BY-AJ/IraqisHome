package com.itcast.iraqishome.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.itcast.iraqishome.R;
import com.itcast.iraqishome.adapter.CenterRecycAdapter;
import com.itcast.iraqishome.bean.CenterBean;
import com.itcast.iraqishome.net.RequestNetwork;
import com.itcast.iraqishome.utills.ConstantUtil;
import com.itcast.iraqishome.utills.UIUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 账户中心
 * Created by yb on 2017/11/14.
 */

public class CenterFragment extends BaseFragment{
    @BindView(R.id.tv_toolbar_title) TextView tvToolbarTitle;
    @BindView(R.id.iv_toolbar_category)ImageView ivToolbarCategory;
    @BindView(R.id.tv_toolbar_setting)TextView tvToolbarSetting;
    @BindView(R.id.iv_center_icon) ImageView ivCenterIcon;
    @BindView(R.id.tv_center_menu) TextView tvCenterMenu;
    @BindView(R.id.recycler_center_item1) RecyclerView mRecyclerViewItem1;
    @BindView(R.id.recycler_center_item2) RecyclerView mRecyclerViewItem2;
    private ArrayList<CenterBean.MenuInfo> mCenterMenusData;

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

        LinearLayoutManager layoutManager = new LinearLayoutManager(UIUtils.getContext());
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(UIUtils.getContext());
        mRecyclerViewItem1.setLayoutManager(layoutManager);
        mRecyclerViewItem2.setLayoutManager(layoutManager2);
    }

    @Override
    public void initData() {
        Call<CenterBean> call = RequestNetwork.getCenterClient();
        call.enqueue(new Callback<CenterBean>() {
            @Override
            public void onResponse(Call<CenterBean> call, Response<CenterBean> response) {
                parseData(response.body());
            }
            @Override
            public void onFailure(Call<CenterBean> call, Throwable t) {
                Logger.d(t.getMessage());
            }
        });
    }

    private void parseData(CenterBean body) {
        mCenterMenusData = body.InnerData.CenterMenus;
        //设置我的订单
        initOrder();
        //设置关于优惠的条目
        initDiscount();
        //设置关于常见的条目
        initCommon();
    }

    private void initCommon() {
        List<CenterBean.ItemInfo> list = new ArrayList<>();
        ArrayList<CenterBean.ItemInfo> mCommon= mCenterMenusData.get(2).Menus;
        for (int i=0;i<mCommon.size();i++) {
            list.add(mCommon.get(i));
        }
        Logger.d("常见:"+list.size());
        CenterRecycAdapter mAdapter = new CenterRecycAdapter(list);
        mRecyclerViewItem2.setAdapter(mAdapter);
    }

    private void initDiscount() {
        List<CenterBean.ItemInfo> mData = new ArrayList<>();
        ArrayList<CenterBean.ItemInfo> mDiscount= mCenterMenusData.get(1).Menus;
        for (int i=0;i<mDiscount.size();i++) {
            mData.add(mDiscount.get(i));
        }
        CenterRecycAdapter mAdapter = new CenterRecycAdapter(mData);
        mRecyclerViewItem1.setAdapter(mAdapter);
    }

    private void initOrder() {
        tvCenterMenu.setText(mCenterMenusData.get(0).Menus.get(0).Title);
        Glide.with(UIUtils.getContext())
                .load(ConstantUtil.IMAGE_BAISC+mCenterMenusData.get(0).Menus.get(0).Icon)
                .into(ivCenterIcon);
    }
}
