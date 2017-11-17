package com.itcast.iraqishome.fragment.yb;

import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;

import com.itcast.iraqishome.R;
import com.itcast.iraqishome.adapter.HomeAdapter;
import com.itcast.iraqishome.bean.TablayoutBean;
import com.itcast.iraqishome.fragment.BaseFragment;
import com.itcast.iraqishome.net.RequestNetwork;
import com.itcast.iraqishome.view.NoScrollViewPager;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 首页
 * Created by yb on 2017/11/14.
 */

public class HomeFragment extends BaseFragment{
    @BindView(R.id.tablayout) TabLayout mTabLayout;
    @BindView(R.id.viewpager_home) NoScrollViewPager mViewPager;
    private ArrayList<TablayoutBean.EntityInfo> mIndexNavList;
    private HomeAdapter mAdapter;

    @Override
    public View initView() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void initData() {
        //请求网络获取数据
        Call<TablayoutBean> call = RequestNetwork.getTablayoutClient();
        call.enqueue(new Callback<TablayoutBean>() {
            @Override
            public void onResponse(Call<TablayoutBean> call, Response<TablayoutBean> response) {
                //解析数据
                parseData(response.body());
            }
            @Override
            public void onFailure(Call<TablayoutBean> call, Throwable t) {
                Logger.d(t.getMessage());
            }
        });
    }

    private void parseData(TablayoutBean body) {
        Logger.d( body.InnerData.IndexNav.size());
        //1.获取tablayout集合数据
        mIndexNavList = body.InnerData.IndexNav;
        //2.获取适配器
        mAdapter = new HomeAdapter(getFragmentManager(),mIndexNavList);
        //3.设置Viewpager适配器
        mViewPager.setAdapter(mAdapter);
        //4.设置tablayout与Viewpager同步
        mTabLayout.setupWithViewPager(mViewPager);
        //5.设置tablayout的标题来源于Viewpager
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
        //6.设置缓存页数
        mViewPager.setOffscreenPageLimit(mIndexNavList.size());
    }
}
