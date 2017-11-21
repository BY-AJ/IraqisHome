package com.itcast.iraqishome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.itcast.iraqishome.R;
import com.itcast.iraqishome.adapter.GoodsHeaderAdapter;
import com.itcast.iraqishome.bean.GoodsDetailBean;
import com.itcast.iraqishome.net.RequestNetwork;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yb on 2017/11/21.
 */

public class GoodsDetailsActivity extends BaseActivity{

    @BindView(R.id.tv_toolbar_title) TextView tvToolbarTitle;
    @BindView(R.id.iv_toolbar_category) ImageView ivToolbarCategory;
    @BindView(R.id.iv_toolbar_back) ImageView ivToolbarBack;
    @BindView(R.id.viewpager_goods) ViewPager mViewPager;
    @BindView(R.id.tv_goods_header_name) TextView tvGoodsHeaderName;
    @BindView(R.id.tv_goods_header_appeal) TextView tvGoodsHeaderAppeal;
    @BindView(R.id.tv_goods_header_price) TextView tvGoodsHeaderPrice;

    private int mItemInfoId;
    private GoodsDetailBean.EntityInfo mInnerDatas;
    private ArrayList<GoodsDetailBean.HeaderInfo> mHeaderDatas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);

        initBasic();//初始化基本信息
        initData();//加载数据
    }

    private void initData() {
        Call<GoodsDetailBean> call = RequestNetwork.getGoodsDetailClient(mItemInfoId);
        call.enqueue(new Callback<GoodsDetailBean>() {
            @Override
            public void onResponse(Call<GoodsDetailBean> call, Response<GoodsDetailBean> response) {
                parseData(response.body());//解析数据
            }
            @Override
            public void onFailure(Call<GoodsDetailBean> call, Throwable t) {
                Logger.d(t.getMessage());
            }
        });
    }

    private void parseData(GoodsDetailBean body) {
        Logger.d(body.Message+".."+body.Status+"..."+body.Result);
        mInnerDatas = body.InnerData;
        //设置商品介绍头部信息
        setHeaderInfo();
    }

    private void setHeaderInfo() {
        tvGoodsHeaderName.setText(mInnerDatas.Name);//设置名称
        tvGoodsHeaderAppeal.setText(mInnerDatas.Caption);//设置小标题
        tvGoodsHeaderPrice.setText("￥"+mInnerDatas.SalePrice);//设置价格
        mHeaderDatas = mInnerDatas.Headers;
        //设置轮播图
        mViewPager.setAdapter(new GoodsHeaderAdapter(GoodsDetailsActivity.this,mHeaderDatas));
    }

    private void initBasic() {
        ButterKnife.bind(this);
        Intent intent = getIntent();
        mItemInfoId = intent.getIntExtra("id", -1);//接受传递过来的条目id
        tvToolbarTitle.setText("商品介绍");
        ivToolbarBack.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.iv_toolbar_back)
    public void finshActivity(){
        finish();
    }
}
