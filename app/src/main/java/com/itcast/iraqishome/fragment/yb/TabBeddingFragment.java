package com.itcast.iraqishome.fragment.yb;

import android.annotation.SuppressLint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.itcast.iraqishome.R;
import com.itcast.iraqishome.adapter.TabFrontRecycAdapter;
import com.itcast.iraqishome.adapter.TabHeaderRecycAdapter;
import com.itcast.iraqishome.adapter.entity.FrontSectionBean;
import com.itcast.iraqishome.adapter.entity.FrontSectionEntity;
import com.itcast.iraqishome.bean.TabWorkBean;
import com.itcast.iraqishome.fragment.BaseFragment;
import com.itcast.iraqishome.net.RequestNetwork;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yb on 2017/11/19.
 */

@SuppressLint("ValidFragment")
public class TabBeddingFragment extends BaseFragment{

    @BindView(R.id.recycler_header) RecyclerView mRecyclerHeader;
    @BindView(R.id.recycler_front) RecyclerView mRecyclerFront;
    @BindView(R.id.tv_basic_title) TextView tvBasicTitle;
    @BindView(R.id.tv_basic_des) TextView tvBasicDes;

    private int mItemIndexId;
    private ArrayList<TabWorkBean.CategoryInfo> mCategoryDatas;
    private TabHeaderRecycAdapter mHeaderAdapter;
    private ArrayList<TabWorkBean.CEORecommendsInfo> mCeoRecommendDatas;
    private TabWorkBean.CEORecommend mCeoRecommendTitle;
    private TabFrontRecycAdapter mFrontAdapter;

    public TabBeddingFragment(int id) {
        super();
        mItemIndexId = id;
    }

    @Override
    public View initView() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.fragment_tab_basic, null);
        initBasic(view);
        return view;
    }

    private void initBasic(View view) {
        ButterKnife.bind(this,view);

        //设置标题
        tvBasicTitle.setText("睡得多却依旧休息不好？\n我们帮你夜夜好梦。");
        //设置描述
        tvBasicDes.setText("每天睡十个小时，却依旧觉得疲惫不堪？总觉得枕头高了、床垫太软了、被子" +
                "不舒服？别再将就你的睡眠了！我们为你准备了各式各样的床品，总有一款能帮你一夜好梦！");

//        GridLayoutManager headerManager = new FullyGridLayoutManager(mActivity,4,GridLayoutManager.VERTICAL,true);
//        mRecyclerHeader.setLayoutManager(headerManager);
//
//        FullyLinearLayoutManager frontManager = new FullyLinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL,true);
//        mRecyclerFront.setLayoutManager(frontManager);
        GridLayoutManager headerManager = new GridLayoutManager(mActivity,4);
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
        //1.获取头recycler要加载的数据集合
        mCategoryDatas = body.InnerData.Categories;
        //2.获取尾recycler要加载的数据集合
        mCeoRecommendDatas = body.InnerData.CEORecommends;
        //3.获取尾recycler的标题数据
        mCeoRecommendTitle = body.InnerData.CEORecommendTitle;

        //4.设置头recycler适配器
        mHeaderAdapter = new TabHeaderRecycAdapter(mCategoryDatas);
        mRecyclerHeader.setAdapter(mHeaderAdapter);
        //5.设置尾recycler适配器
        List<FrontSectionEntity> mEntityList = new ArrayList<>();
        //5.1设置分组头标题
        mEntityList.add(new FrontSectionEntity(true,mCeoRecommendTitle.Text));
        //5.2添加条目数据
        for (int i=0 ;i<mCeoRecommendDatas.size();i++) {
            FrontSectionBean bean = new FrontSectionBean();
            bean.ActivityPrice = mCeoRecommendDatas.get(i).ActivityPrice;
            bean.Appeal = mCeoRecommendDatas.get(i).Appeal;
            bean.Code = mCeoRecommendDatas.get(i).Code;
            bean.CommentCount = mCeoRecommendDatas.get(i).CommentCount;
            bean.ImageUrl = mCeoRecommendDatas.get(i).ImageUrl;
            bean.ItemInfoId = mCeoRecommendDatas.get(i).ItemInfoId;
            bean.Name = mCeoRecommendDatas.get(i).Name;
            bean.PriceTag = mCeoRecommendDatas.get(i).PriceTag;
            bean.SalePrice = mCeoRecommendDatas.get(i).SalePrice;
            bean.Uri = mCeoRecommendDatas.get(i).Uri;
            mEntityList.add(new FrontSectionEntity(bean));
        }
        mFrontAdapter = new TabFrontRecycAdapter(
                R.layout.recycler_item_front,
                R.layout.recycler_item_front_header,
                mEntityList);
        mRecyclerFront.setAdapter(mFrontAdapter);

    }
}
