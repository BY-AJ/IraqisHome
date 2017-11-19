package com.itcast.iraqishome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.itcast.iraqishome.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yb on 2017/11/19.
 */

public class GraspActivity extends BaseActivity{

    @BindView(R.id.webview) WebView mWebView;
    @BindView(R.id.tv_toolbar_title) TextView tvToolbarTitle;
    @BindView(R.id.iv_toolbar_category) ImageView ivToolbarCategory;
    @BindView(R.id.iv_toolbar_back) ImageView ivToolbarBack;

    private String mUrl;
    private String mName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grasp);

        initBasic();

        initData();
    }

    private void initData() {
        mWebView.loadUrl(mUrl);
    }

    private void initBasic() {
        ButterKnife.bind(this);
        Intent intent = getIntent();
        mUrl = intent.getStringExtra("url");
        mName = intent.getStringExtra("name");

        tvToolbarTitle.setText(mName);
        ivToolbarCategory.setVisibility(View.GONE);
        ivToolbarBack.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.iv_toolbar_back)
    public void finshActivity(){
        Intent intent = new Intent();
        intent.putExtra("success",true);
        setResult(110,intent);
        finish();
    }
}
