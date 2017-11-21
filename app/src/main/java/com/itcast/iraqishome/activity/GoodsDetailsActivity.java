package com.itcast.iraqishome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.itcast.iraqishome.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yb on 2017/11/21.
 */

public class GoodsDetailsActivity extends BaseActivity{

    @BindView(R.id.tv_toolbar_title) TextView tvToolbarTitle;
    @BindView(R.id.iv_toolbar_category) ImageView ivToolbarCategory;
    @BindView(R.id.iv_toolbar_back) ImageView ivToolbarBack;
    private int mItemInfoId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);

        initBasic();
        initData();
    }

    private void initData() {

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
