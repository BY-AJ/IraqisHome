package com.itcast.iraqishome.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.itcast.iraqishome.R;
import com.itcast.iraqishome.bean.ShopBean;
import com.itcast.iraqishome.utills.ConstantUtil;

import java.util.List;

/**
 * Created by yb on 2017/11/26.
 */

public class ShopRecycAdapter extends BaseQuickAdapter<ShopBean.EntityInfo,BaseViewHolder>{

    public ShopRecycAdapter(@Nullable List<ShopBean.EntityInfo> data) {
        super(R.layout.recycler_item_shop,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopBean.EntityInfo item) {
        helper.setText(R.id.tv_shop_title,item.Name);
        helper.setText(R.id.tv_shop_price,"￥"+item.SalePrice);
        ImageView icon = helper.itemView.findViewById(R.id.iv_shop_icon);
        Glide.with(helper.itemView.getContext())
                .load(ConstantUtil.IMAGE_BAISC+item.ImageUrl)
                .into(icon);
    }
}
