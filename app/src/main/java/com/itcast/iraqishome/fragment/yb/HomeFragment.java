package com.itcast.iraqishome.fragment.yb;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;

import com.itcast.iraqishome.R;
import com.itcast.iraqishome.activity.GraspActivity;
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
    private int mCount;

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
        //6.设置Viewpager缓存页数
        mViewPager.setOffscreenPageLimit(mIndexNavList.size());
        //7.设置tablayout默认选中
        mTabLayout.getTabAt(0).select();

        mCount = mTabLayout.getTabCount();
        Logger.d("tab个数:"+mCount);
        for (int i=0;i<mCount;i++) {
            if(i == mCount -1) {
                //获取最后一个tab
                TabLayout.Tab tab = mTabLayout.getTabAt(i);
                if(tab != null) {
                    //对应tab定制view
                    tab.setCustomView(getTabView());
                    if(tab.getCustomView() != null) {
                        //获取tab对应父Item
                        View view = (View) tab.getCustomView().getParent();
                        //设置点击事件
                        view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(mActivity, GraspActivity.class);
                                intent.putExtra("url",mIndexNavList.get(mCount-1).Uri);
                                intent.putExtra("name",mIndexNavList.get(mCount-1).Name);
                                startActivityForResult(intent,100);
                            }
                        });
                    }
                }
            }
        }
    }

    private View getTabView() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.tab_life, null);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 100 && resultCode == 110) {
            boolean success = data.getBooleanExtra("success", false);
            if(success) {
                mTabLayout.getTabAt(mCount-2).select();
            }
        }
    }
}
