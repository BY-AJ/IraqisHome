package com.itcast.iraqishome.fragment.yb;

import android.annotation.SuppressLint;
import android.view.View;

import com.itcast.iraqishome.fragment.BaseFragment;

/**
 * Created by yb on 2017/11/19.
 */

@SuppressLint("ValidFragment")
public class TabGraspFragment extends BaseFragment{

    private String mUrl;
    private String mName;

    public TabGraspFragment(String uri, String name) {
        super();
        mUrl = uri;
        mName = name;
    }

    @Override
    public View initView() {
//        Intent intent = new Intent(mActivity, GraspActivity.class);
//        intent.putExtra("url",mUrl);
//        intent.putExtra("name",mName);
//        startActivity(intent);
        return null;
    }

    @Override
    public void initData() {
//        Intent intent = new Intent(mActivity, GraspActivity.class);
//        intent.putExtra("url",mUrl);
//        intent.putExtra("name",mName);
//        startActivity(intent);
    }
}
