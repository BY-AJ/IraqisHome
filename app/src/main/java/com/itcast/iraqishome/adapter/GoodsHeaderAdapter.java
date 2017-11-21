package com.itcast.iraqishome.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.itcast.iraqishome.bean.GoodsDetailBean;
import com.itcast.iraqishome.utills.ConstantUtil;

import java.util.ArrayList;

/**
 * Created by yb on 2017/11/21.
 */

public class GoodsHeaderAdapter extends PagerAdapter{

    private ArrayList<GoodsDetailBean.HeaderInfo> data;
    private Context context;

    public GoodsHeaderAdapter(Context context, ArrayList<GoodsDetailBean.HeaderInfo> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView view = new ImageView(context);
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(context).load(ConstantUtil.IMAGE_BAISC+data.get(position).ImageUrl).into(view);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
