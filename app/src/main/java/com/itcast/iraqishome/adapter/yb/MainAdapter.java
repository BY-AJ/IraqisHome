package com.itcast.iraqishome.adapter.yb;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.itcast.iraqishome.fragment.BaseFragment;
import com.itcast.iraqishome.fragment.FragmentFactory;

/**
 * Created by yb on 2017/11/14.
 */

public class MainAdapter extends FragmentPagerAdapter{

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = FragmentFactory.createMainFragment(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
