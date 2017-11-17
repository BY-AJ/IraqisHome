package com.itcast.iraqishome.fragment.yb;

import android.annotation.SuppressLint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.itcast.iraqishome.R;
import com.itcast.iraqishome.adapter.TabWorkHeaderRecycAdapter;
import com.itcast.iraqishome.bean.TabWorkBean;
import com.itcast.iraqishome.fragment.BaseFragment;
import com.itcast.iraqishome.net.RequestNetwork;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Tablayout-----家务
 * Created by yb on 2017/11/14.
 */

@SuppressLint("ValidFragment")
public class TabWorkFragment extends BaseFragment{

    @BindView(R.id.recycler_header) RecyclerView mRecyclerHeader;
    @BindView(R.id.recycler_front) RecyclerView mRecyclerFront;

    private int mItemIndexId;
    private ArrayList<TabWorkBean.CategoryInfo> mCategoryDatas;
    private TabWorkHeaderRecycAdapter mHeaderAdapter;

    public TabWorkFragment(int id) {
        super();
        mItemIndexId = id;
    }

    @Override
    public View initView() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.fragment_tabwork, null);
        initBasic(view);
        return view;
    }

    private void initBasic(View view) {
        ButterKnife.bind(this,view);

        GridLayoutManager headerManager = new GridLayoutManager(mActivity, 4);
        mRecyclerHeader.setLayoutManager(headerManager);

        LinearLayoutManager frontManager = new LinearLayoutManager(mActivity);
        mRecyclerFront.setLayoutManager(frontManager);

    }

    @Override
    public void initData() {
        Call<TabWorkBean> call = RequestNetwork.getTabWorkClient(mItemIndexId);
        call.enqueue(new Callback<TabWorkBean>() {
            @Override
            public void onResponse(Call<TabWorkBean> call, Response<TabWorkBean> response) {
                parseData(response.body());
            }
            @Override
            public void onFailure(Call<TabWorkBean> call, Throwable t) {
                Logger.d(t.getMessage());
            }
        });
    }

    private void parseData(TabWorkBean body) {
        Logger.d(body.InnerData.Categories.size()+"..."+body.Message+"..."+body.Result);
        mCategoryDatas = body.InnerData.Categories;
        mHeaderAdapter = new TabWorkHeaderRecycAdapter(mCategoryDatas);
        mRecyclerHeader.setAdapter(mHeaderAdapter);
    }
}
