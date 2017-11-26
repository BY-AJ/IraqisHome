package com.itcast.iraqishome.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.itcast.iraqishome.R;
import com.itcast.iraqishome.bean.LimitedDetailBean;
import com.itcast.iraqishome.net.RequestNetwork;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 限时特惠
 * Created by yb on 2017/11/25.
 */

public class LimitedActivity extends BaseActivity{
    @BindView(R.id.tv_toolbar_title) TextView tvToolbarTitle;
    @BindView(R.id.iv_toolbar_category) ImageView ivToolbarCategory;
    @BindView(R.id.iv_toolbar_back) ImageView ivToolbarBack;
    @BindView(R.id.iv_limited_banner) ImageView ivLimitedBanner;
    @BindView(R.id.recycler_limited) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limited);
        initBasic();
        initData();
    }

    private void initBasic() {
        ButterKnife.bind(this);
        tvToolbarTitle.setText("限时特惠");
        ivToolbarBack.setVisibility(View.VISIBLE);
        ivToolbarCategory.setVisibility(View.GONE);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void initData() {
        //TODO 出现问题了
        Call<LimitedDetailBean> call = RequestNetwork.getLimitedClient();
        call.enqueue(new Callback<LimitedDetailBean>() {
            @Override
            public void onResponse(Call<LimitedDetailBean> call, Response<LimitedDetailBean> response) {
                parseData(response.body());
            }
            @Override
            public void onFailure(Call<LimitedDetailBean> call, Throwable t) {
                Logger.d(t.getMessage());
            }
        });
    }

    private void parseData(LimitedDetailBean body) {
        Logger.d("限时特惠:"+body.InnerData.HeaderBanners.size());
    }


    @OnClick(R.id.iv_toolbar_back)
    public void backPreActivity(){
        finish();
    }
}
