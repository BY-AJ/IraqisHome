package com.itcast.iraqishome.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.itcast.iraqishome.R;
import com.itcast.iraqishome.bean.StrollBean;
import com.itcast.iraqishome.net.RequestNetwork;
import com.itcast.iraqishome.utills.UIUtils;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 闲逛
 * Created by yb on 2017/11/14.
 */

public class StrollFragment extends BaseFragment{
    @BindView(R.id.recycler_stroll) RecyclerView mRecyclerView;
    @BindView(R.id.tv_toolbar_title) TextView tvToolbarTitle;
    @BindView(R.id.iv_toolbar_category)ImageView ivToolbarCategory;

    @Override
    public View initView() {
        View view = LayoutInflater.from(UIUtils.getContext()).inflate(R.layout.fragment_stroll, null);
        initBasic(view);
        return view;
    }

    private void initBasic(View view) {
        ButterKnife.bind(this,view);
        tvToolbarTitle.setText("闲逛");
        ivToolbarCategory.setVisibility(View.GONE);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void initData() {
        Call<StrollBean> call = RequestNetwork.getStrollClient(1);
        call.enqueue(new Callback<StrollBean>() {
            @Override
            public void onResponse(Call<StrollBean> call, Response<StrollBean> response) {
                parseData(response.body());
            }
            @Override
            public void onFailure(Call<StrollBean> call, Throwable t) {
                Logger.d(t.getMessage());
            }
        });
    }

    private void parseData(StrollBean body) {
        Logger.d("闲逛:"+body.Message+".."+body.InnerData.StrollList.size());
    }
}
