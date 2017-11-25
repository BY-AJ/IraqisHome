package com.itcast.iraqishome.fragment;

import com.itcast.iraqishome.bean.TablayoutBean;
import com.itcast.iraqishome.fragment.yb.HomeFragment;
import com.itcast.iraqishome.fragment.yb.TabBeddingFragment;
import com.itcast.iraqishome.fragment.yb.TabCookFragment;
import com.itcast.iraqishome.fragment.yb.TabGraspFragment;
import com.itcast.iraqishome.fragment.yb.TabLifeFragment;
import com.itcast.iraqishome.fragment.yb.TabProductFragment;
import com.itcast.iraqishome.fragment.yb.TabSuitFragment;
import com.itcast.iraqishome.fragment.yb.TabWashFragment;
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

    public static BaseFragment createHomeFragment(int pos, TablayoutBean.EntityInfo info) {
        BaseFragment fragment = mHomeFragmentMap.get(pos);
        if(fragment == null) {
            switch (pos) {
                case 0:
                    fragment = new TabProductFragment();
                    break;
                case 1:
                    fragment = new TabProductFragment();
                    break;
                case 2:
                    fragment = new TabWorkFragment(info.ItemIndexId);
                    break;
                case 3:
                    fragment = new TabCookFragment(info.ItemIndexId);
                    break;
                case 4:
                    fragment = new TabLifeFragment(info.ItemIndexId);
                    break;
                case 5:
                    fragment = new TabSuitFragment(info.ItemIndexId);
                    break;
                case 6:
                    fragment = new TabBeddingFragment(info.ItemIndexId);
                    break;
                case 7:
                    fragment = new TabWashFragment(info.ItemIndexId);
                    break;
                case 8:
                    fragment = new TabGraspFragment();
                    break;
                default:
                    break;
            }
            mHomeFragmentMap.put(pos,fragment);
        }
        return fragment;
    }
}
