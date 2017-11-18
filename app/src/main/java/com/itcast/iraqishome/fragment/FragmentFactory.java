package com.itcast.iraqishome.fragment;

import com.itcast.iraqishome.fragment.yb.HomeFragment;
import com.itcast.iraqishome.fragment.yb.TabCookFragment;
import com.itcast.iraqishome.fragment.yb.TabHomeFragment;
import com.itcast.iraqishome.fragment.yb.TabProductFragment;
import com.itcast.iraqishome.fragment.yb.TabWorkFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yb on 2017/11/14.
 */

public class FragmentFactory {
    //保存MainActivity中的ViewPager中fragment
    private static Map<Integer,BaseFragment> mMainFragmentMap = new HashMap<>();

    //保存HomeFragment中的ViewPager中fragment
    private static Map<Integer,BaseFragment> mHomeFragmentMap = new HashMap<>();

    public static BaseFragment createMainFragment(int pos) {
        BaseFragment fragment = mMainFragmentMap.get(pos);
        if(fragment == null) {
            switch (pos) {
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new ProductFragment();
                    break;
                case 2:
                    fragment = new StrollFragment();
                    break;
                case 3:
                    fragment = new ShoppingCartFragment();
                    break;
                case 4:
                    fragment = new CenterFragment();
                    break;
                default:
                    break;
            }
            mMainFragmentMap.put(pos,fragment);
        }
        return fragment;
    }

    public static BaseFragment createHomeFragment(int pos, int id) {
        BaseFragment fragment = mHomeFragmentMap.get(pos);
        if(fragment == null) {
            switch (pos) {
                case 0:
                    fragment = new TabHomeFragment();
                    break;
                case 1:
                    fragment = new TabProductFragment();
                    break;
                case 2:
                    fragment = new TabWorkFragment(id);
                    break;
                case 3:
                    fragment = new TabCookFragment(id);
                    break;
                case 4:
                    fragment = new CenterFragment();
                    break;
                case 5:
                    fragment = new ProductFragment();
                    break;
                case 6:
                    fragment = new StrollFragment();
                    break;
                case 7:
                    fragment = new ShoppingCartFragment();
                    break;
                case 8:
                    fragment = new CenterFragment();
                    break;
                default:
                    break;
            }
            mHomeFragmentMap.put(pos,fragment);
        }
        return fragment;
    }
}
