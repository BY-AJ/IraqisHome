package com.itcast.iraqishome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.itcast.iraqishome.R;
import com.itcast.iraqishome.adapter.GoodsHeaderAdapter;
import com.itcast.iraqishome.bean.GoodsDetailBean;
import com.itcast.iraqishome.net.RequestNetwork;
import com.itcast.iraqishome.utills.UIUtils;
import com.itcast.iraqishome.view.CountView;
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
    @BindView(R.id.ll_header_root) LinearLayout llHeaderRoot;
    @BindView(R.id.countview) CountView mCountView;

    private int mItemInfoId;
    private int mPreiousPos;
    private GoodsDetailBean.EntityInfo mInnerDatas;
    private ArrayList<GoodsDetailBean.HeaderInfo> mHeaderDatas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
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

    /**
     * 设置商品头部信息
     */
    private void setHeaderInfo() {
        tvGoodsHeaderName.setText(mInnerDatas.Name);//设置名称
        tvGoodsHeaderAppeal.setText(mInnerDatas.Caption);//设置小标题
        tvGoodsHeaderPrice.setText("￥"+mInnerDatas.SalePrice);//设置价格
        mHeaderDatas = mInnerDatas.Headers;
        //设置ViewPager适配器
        mViewPager.setAdapter(new GoodsHeaderAdapter(GoodsDetailsActivity.this,mHeaderDatas));
        //添加小圆点
        for (int i=0;i<mHeaderDatas.size();i++) {
            ImageView point = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                    , LinearLayout.LayoutParams.WRAP_CONTENT);
            if(i == 0) {
                point.setImageResource(R.drawable.shape_point_pressed);
            }else {
                point.setImageResource(R.drawable.shape_point_normal);
                params.leftMargin = UIUtils.dip2px(10);
                point.setLayoutParams(params);
            }
            llHeaderRoot.addView(point);
        }
        //开始轮播
        startRotation();
        //设置页面监听,实现小圆点的滚动
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                //页面选中回调该方法
                position = position%mHeaderDatas.size();
                ImageView point = (ImageView) llHeaderRoot.getChildAt(position);
                point.setImageResource(R.drawable.shape_point_pressed);
                //上个点变为不选中
                ImageView prePoint = (ImageView)llHeaderRoot.getChildAt(mPreiousPos);
                prePoint.setImageResource(R.drawable.shape_point_normal);
                mPreiousPos = position;
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    /**
     * 实现轮播图的效果
     */
    private void startRotation() {
        //设置页面从mAdDatas.size*10000位置开始滚动
        mViewPager.setCurrentItem(mHeaderDatas.size()*10000);
        //实现头条的轮播
        new RunnableTask().start();
    }

    private class RunnableTask implements Runnable {
        public void start() {
            //每次开始的时候，清除之前的消息，避免消息的重复
            UIUtils.getHandler().removeCallbacksAndMessages(null);
            UIUtils.getHandler().postDelayed(this,3000);
        }
        @Override
        public void run() {
            int currentItem = mViewPager.getCurrentItem();
            currentItem++;
            mViewPager.setCurrentItem(currentItem);
            UIUtils.getHandler().postDelayed(this,3000);
        }
    }

    /**
     * 加入购物车
     */
    @OnClick(R.id.btn_shoppingCart)
    public void addShoppingCart(){
        Toast.makeText(this,mCountView.getCount()+"",Toast.LENGTH_SHORT).show();
    }

    /**
     * 初始化基本信息
     */
    private void initBasic() {
        ButterKnife.bind(this);
        Intent intent = getIntent();
        mItemInfoId = intent.getIntExtra("id", -1);//接受传递过来的条目id
        tvToolbarTitle.setText("商品介绍");
        ivToolbarBack.setVisibility(View.VISIBLE);
    }

    /**
     * 返回上一个活动
     */
    @OnClick(R.id.iv_toolbar_back)
    public void finshActivity(){
        finish();
    }
}
