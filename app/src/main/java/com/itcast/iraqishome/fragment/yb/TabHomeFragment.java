package com.itcast.iraqishome.fragment.yb;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.itcast.iraqishome.R;
import com.itcast.iraqishome.bean.TabHomeBean;
import com.itcast.iraqishome.fragment.BaseFragment;
import com.itcast.iraqishome.net.RequestNetwork;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Tablayout-----首页
 * Created by yb on 2017/11/14.
 */

public class TabHomeFragment extends BaseFragment{
    @BindView(R.id.viewpager_tabhome) ViewPager mViewPager;
    @BindView(R.id.recycler_tabhome) RecyclerView mRecyclerView;
    private TabHomeBean.HomeInfo mHomeBannerInfo;

    @Override
    public View initView() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.fragment_tabhome, null);
        //初始化基本信息
        initBasic(view);
        return view;
    }

    private void initBasic(View view) {
        ButterKnife.bind(this,view);
        //设置RecyclerView布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void initData() {
        Call<TabHomeBean> call = RequestNetwork.getTabHomeClient();
        call.enqueue(new Callback<TabHomeBean>() {
            @Override
            public void onResponse(Call<TabHomeBean> call, Response<TabHomeBean> response) {
                //解析数据
                parseData(response.body());
            }
            @Override
            public void onFailure(Call<TabHomeBean> call, Throwable t) {
                Logger.d(t.getMessage());
            }
        });
    }

    private void parseData(TabHomeBean body) {
        Logger.d(body.InnerData.length);
    }

}
