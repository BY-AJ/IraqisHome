package com.itcast.iraqishome.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.itcast.iraqishome.MainActivity;
import com.itcast.iraqishome.R;
import com.itcast.iraqishome.adapter.ShopRecycAdapter;
import com.itcast.iraqishome.bean.ShopBean;
import com.itcast.iraqishome.net.RequestNetwork;
import com.itcast.iraqishome.utills.UIUtils;
import com.itcast.iraqishome.view.NoScrollViewPager;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    private ArrayList<ShopBean.EntityInfo> mRecommendDatas;
    private ShopRecycAdapter mAdapter;
    private NoScrollViewPager viewPager;

    @Override
    public View initView() {
        View view = LayoutInflater.from(UIUtils.getContext()).inflate(R.layout.fragment_shoppingcart, null);
        initBasic(view);
        return view;
    }

    private void initBasic(View view) {
        ButterKnife.bind(this,view);
        //获取依赖的Activity中的控件
        activity = (MainActivity)mActivity;
        viewPager = activity.getViewPager();

        tvToolbarTitle.setText("购物车");
        ivToolbarCategory.setVisibility(View.GONE);
        ivToolbarBack.setVisibility(View.VISIBLE);

        LinearLayoutManager layoutManager = new LinearLayoutManager(UIUtils.getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

    }

    @OnClick(R.id.iv_toolbar_back)
    public void backPreActivity(){
        int currentItem = viewPager.getCurrentItem();
        currentItem--;
        viewPager.setCurrentItem(currentItem);
    }

    @OnClick(R.id.btn_shop_stroll)
    public void stroll(){
        viewPager.setCurrentItem(0);
    }

    @Override
    public void initData() {
        Call<ShopBean> call = RequestNetwork.getShopClient();
        call.enqueue(new Callback<ShopBean>() {
            @Override
            public void onResponse(Call<ShopBean> call, Response<ShopBean> response) {
                parseData(response.body());
            }
            @Override
            public void onFailure(Call<ShopBean> call, Throwable t) {
                Logger.d(t.getMessage());
            }
        });
    }

    private void parseData(ShopBean body) {
        Logger.d("购物车精心推荐："+body.RecommendItems.size());
        mRecommendDatas = body.RecommendItems;
        List<ShopBean.EntityInfo> mDatas=new ArrayList<>();
        for (int i=0;i<mRecommendDatas.size();i++) {
            mDatas.add(mRecommendDatas.get(i));
        }
        mAdapter = new ShopRecycAdapter(mDatas);
        mRecyclerView.setAdapter(mAdapter);
    }

}
