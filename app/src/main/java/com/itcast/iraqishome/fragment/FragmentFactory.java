package com.itcast.iraqishome.fragment;

import com.itcast.iraqishome.fragment.yb.CenterFragment;
import com.itcast.iraqishome.fragment.yb.HomeFragment;
import com.itcast.iraqishome.fragment.yb.ProductFragment;
import com.itcast.iraqishome.fragment.yb.ShoppingCartFragment;
import com.itcast.iraqishome.fragment.yb.StrollFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yb on 2017/11/14.
 */

public class FragmentFactory {
    private static Map<Integer,BaseFragment> mMainFragmentMap = new HashMap<>();

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

    public static BaseFragment createHomeFragment(int pos) {
        BaseFragment fragment = mHomeFragmentMap.get(pos);
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
