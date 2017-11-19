package com.itcast.iraqishome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.itcast.iraqishome.bean.TablayoutBean;
import com.itcast.iraqishome.fragment.BaseFragment;
import com.itcast.iraqishome.fragment.FragmentFactory;

import java.util.ArrayList;

/**
 * Created by yb on 2017/11/14.
 */

public class HomeAdapter extends FragmentPagerAdapter{

    private ArrayList<TablayoutBean.EntityInfo> mIndexNavList;

    public HomeAdapter(FragmentManager fm, ArrayList<TablayoutBean.EntityInfo> list) {
        super(fm);
        mIndexNavList = list;
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = FragmentFactory.createHomeFragment(position,mIndexNavList.get(position));
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mIndexNavList.get(position).Name;
    }

    @Override
    public int getCount() {
        return mIndexNavList.size();
    }
}
