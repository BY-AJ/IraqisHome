package com.itcast.iraqishome.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.itcast.iraqishome.R;
import com.itcast.iraqishome.adapter.ProductRecycAdapter;
import com.itcast.iraqishome.adapter.entity.ProductSectionEntity;
import com.itcast.iraqishome.bean.CategoryBean;
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
 * 全部产品
 * Created by yb on 2017/11/14.
 */

public class ProductFragment extends BaseFragment{
    @BindView(R.id.recycler_product) RecyclerView mRecyclerView;
    @BindView(R.id.tv_toolbar_title) TextView tvToolbarTitle;
    @BindView(R.id.iv_toolbar_category)ImageView ivToolbarCategory;
    @BindView(R.id.et_product_search) EditText etProductSearch;
    @BindView(R.id.btn_product_cancel) Button btnProductCancel;
    private ArrayList<CategoryBean.ChildInfo> mInnerData;
    private ProductRecycAdapter mAdapter;

    @Override
    public View initView() {
        View view = LayoutInflater.from(UIUtils.getContext()).inflate(R.layout.fragment_product, null);
        initBasic(view);
        return view;
    }

    private void initBasic(View view) {
        ButterKnife.bind(this,view);
        tvToolbarTitle.setText("全部产品");
        ivToolbarCategory.setVisibility(View.GONE);

        GridLayoutManager layoutManager = new GridLayoutManager(UIUtils.getContext(), 3);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void initData() {
        Call<CategoryBean> call = RequestNetwork.getProductClient();
        call.enqueue(new Callback<CategoryBean>() {
            @Override
            public void onResponse(Call<CategoryBean> call, Response<CategoryBean> response) {
                parseData(response.body());
            }
            @Override
            public void onFailure(Call<CategoryBean> call, Throwable t) {
                Logger.d(t.getMessage());
            }
        });
    }

    private void parseData(CategoryBean body) {
        Logger.d("全部产品："+body.Message+".."+body.Result+".."+body.Status+".."+body.InnerData.size());
        mInnerData = body.InnerData;
        List<ProductSectionEntity> list = new ArrayList<>();
        for (int i=0;i<mInnerData.size();i++) {
            //添加分组头信息
            list.add(new ProductSectionEntity(true,mInnerData.get(i).Name));
            for (int j=0;j<mInnerData.get(i).Children.size();j++) {
                //添加分组内容信息
                CategoryBean.EntityInfo entityInfo = mInnerData.get(i).Children.get(j);
                list.add(new ProductSectionEntity(entityInfo));
            }
        }
        mAdapter = new ProductRecycAdapter(R.layout.recycler_item_product,
                R.layout.recycler_item_front_header, list);
        mRecyclerView.setAdapter(mAdapter);
    }
}
