package com.itcast.iraqishome.fragment;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.itcast.iraqishome.R;
import com.itcast.iraqishome.activity.GoodsDetailsActivity;
import com.itcast.iraqishome.activity.WebDetailsActivity;
import com.itcast.iraqishome.adapter.StrollRecycAdapter;
import com.itcast.iraqishome.adapter.entity.StrollMultiItemEntity;
import com.itcast.iraqishome.bean.StrollBean;
import com.itcast.iraqishome.net.RequestNetwork;
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
 * 闲逛
 * Created by yb on 2017/11/14.
 */

public class StrollFragment extends BaseFragment implements View.OnClickListener{
    @BindView(R.id.recycler_stroll) RecyclerView mRecyclerView;
    @BindView(R.id.tv_toolbar_title) TextView tvToolbarTitle;
    @BindView(R.id.iv_toolbar_category)ImageView ivToolbarCategory;
    private ArrayList<StrollBean.ListInfo> mStrollList;
    private List<StrollMultiItemEntity> mData;
    private StrollRecycAdapter mAdapter;
    private ArrayList<StrollBean.ConfigerInfo> mConfigerList;

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
        mStrollList = body.InnerData.StrollList;
        mConfigerList = mStrollList.get(1).ConfigerList;
        mData = new ArrayList<>();
        //对数据进行分类设置
        for (int i=0;i<mStrollList.size();i++) {
            StrollBean.ListInfo info = mStrollList.get(i);
            if(info.Type == 3) {
                mData.add(new StrollMultiItemEntity(3,info));
            }else if(info.Type == 1) {
                mData.add(new StrollMultiItemEntity(1,info));
            }
        }
        mAdapter = new StrollRecycAdapter(mData);
        mRecyclerView.setAdapter(mAdapter);

        //configerlist中的各点击事件处理
        initConfiger();
        //列表点击事件处理
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(position == 1) {
                    return;
                }
                Intent intent = new Intent(UIUtils.getContext(), GoodsDetailsActivity.class);
                intent.putExtra("id",mStrollList.get(position).ItemInfoID);
                startActivity(intent);
            }
        });
    }

    private void initConfiger() {
        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                //获取item中的子控件
                adapter.getViewByPosition(mRecyclerView,position, R.id.btn_stroll1)
                        .setOnClickListener(StrollFragment.this);
                adapter.getViewByPosition(mRecyclerView,position, R.id.btn_stroll2)
                        .setOnClickListener(StrollFragment.this);
                adapter.getViewByPosition(mRecyclerView,position, R.id.btn_stroll3)
                        .setOnClickListener(StrollFragment.this);
                adapter.getViewByPosition(mRecyclerView,position, R.id.btn_stroll4)
                        .setOnClickListener(StrollFragment.this);
                adapter.getViewByPosition(mRecyclerView,position, R.id.btn_stroll5)
                        .setOnClickListener(StrollFragment.this);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_stroll1://49元包一年
                intent = new Intent(mActivity, WebDetailsActivity.class);
                intent.putExtra("url",mConfigerList.get(0).LinkUrl);
                intent.putExtra("title","49元包1年洗衣液");
                startActivity(intent);
                break;
            case R.id.btn_stroll2://今日新品
                Toast.makeText(UIUtils.getContext(),"暂时出现问题,程序猿正在路上...",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_stroll3://幸运抽奖
            case R.id.btn_stroll4://幸运抽奖
                intent = new Intent(mActivity, WebDetailsActivity.class);
                intent.putExtra("url",mConfigerList.get(2).LinkUrl);
                intent.putExtra("title","伊人家居");
                startActivity(intent);
                break;
            case R.id.btn_stroll5://限时特惠
                //intent = new Intent(mActivity,LimitedActivity.class);
                //startActivity(intent);
                Toast.makeText(UIUtils.getContext(),"暂时出现问题,程序猿正在路上...",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
