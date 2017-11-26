package com.itcast.iraqishome.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.itcast.iraqishome.R;
import com.itcast.iraqishome.bean.LimitedDetailBean;
import com.itcast.iraqishome.utills.ConstantUtil;

import java.util.List;

/**
 * Created by yb on 2017/11/26.
 */

public class LimitedRecycAdapter extends BaseQuickAdapter<LimitedDetailBean.ItemInfo,BaseViewHolder>{

    public LimitedRecycAdapter(@Nullable List<LimitedDetailBean.ItemInfo> data) {
        super(R.layout.recycler_item_limited,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LimitedDetailBean.ItemInfo item) {
        helper.setText(R.id.tv_limited_title,item.Name);
        helper.setText(R.id.tv_limited_price,"￥ "+item.SalePrice);
        ImageView icon = helper.itemView.findViewById(R.id.iv_limited_pic);
        Glide.with(helper.itemView.getContext())
                .load(ConstantUtil.IMAGE_BAISC+item.ImageUrl)
                .into(icon);
    }
}
