package com.itcast.iraqishome.fragment.yb;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.itcast.iraqishome.R;
import com.itcast.iraqishome.activity.GoodsDetailsActivity;
import com.itcast.iraqishome.adapter.TabProductRecycAdapter;
import com.itcast.iraqishome.bean.TabProductBean;
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
 * Tablayout-----新品
 * Created by yb on 2017/11/14.
 */

public class TabProductFragment extends BaseFragment{
    @BindView(R.id.recycler_tabproduct) RecyclerView mRecyclerView;
    private ArrayList<TabProductBean.EntityInfo> mDatas;
    private TabProductRecycAdapter mAdapter;

    @Override
    public View initView() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.fragment_tabproduct, null);
        initBacis(view);
        return view;
    }

    private void initBacis(View view) {
        ButterKnife.bind(this,view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        //FullyLinearLayoutManager layoutManager = new FullyLinearLayoutManager(mActivity);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void initData() {
        Call<TabProductBean> call = RequestNetwork.getTabProductClient();
        call.enqueue(new Callback<TabProductBean>() {
            @Override
            public void onResponse(Call<TabProductBean> call, Response<TabProductBean> response) {
                parseData(response.body());
            }
            @Override
            public void onFailure(Call<TabProductBean> call, Throwable t) {
                Logger.d(t.getMessage());
            }
        });
    }

    private void parseData(TabProductBean body) {
        Logger.d(body.InnerData.size()+"....");
        mDatas = body.InnerData;
        mAdapter = new TabProductRecycAdapter(mDatas);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mActivity, GoodsDetailsActivity.class);
                intent.putExtra("id",mDatas.get(position).ItemInfoId);
                startActivity(intent);
            }
        });
    }
}
