package com.itcast.iraqishome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.itcast.iraqishome.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 网页展示
 * Created by yb on 2017/11/25.
 */

public class WebDetailsActivity extends BaseActivity{
    @BindView(R.id.tv_toolbar_title) TextView tvToolbarTitle;
    @BindView(R.id.iv_toolbar_category) ImageView ivToolbarCategory;
    @BindView(R.id.iv_toolbar_back) ImageView ivToolbarBack;
    @BindView(R.id.webview) WebView mWebView;

    private String mUrl;
    private String mTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initBasic();

        initData();
    }

    private void initData() {
        mWebView.loadUrl(mUrl);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
    }

    private void initBasic() {
        ButterKnife.bind(this);
        ivToolbarBack.setVisibility(View.VISIBLE);
        ivToolbarCategory.setVisibility(View.GONE);

        Intent intent = getIntent();
        mUrl = intent.getStringExtra("url");
        mTitle = intent.getStringExtra("title");
        tvToolbarTitle.setText(mTitle);
    }

    @OnClick(R.id.iv_toolbar_back)
    public void backPreActivity(){
        finish();
    }

}
