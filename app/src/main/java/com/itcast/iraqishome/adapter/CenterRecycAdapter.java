package com.itcast.iraqishome.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.itcast.iraqishome.R;
import com.itcast.iraqishome.bean.CenterBean;
import com.itcast.iraqishome.utills.ConstantUtil;

import java.util.List;

/**
 * Created by yb on 2017/11/26.
 */

public class CenterRecycAdapter extends BaseQuickAdapter<CenterBean.ItemInfo,BaseViewHolder>{

    public CenterRecycAdapter(@Nullable List<CenterBean.ItemInfo> data) {
        super(R.layout.recycler_item_center,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CenterBean.ItemInfo item) {
        helper.setText(R.id.tv_center_menu,item.Title);
        ImageView icon = helper.itemView.findViewById(R.id.iv_center_icon);
        Glide.with(helper.itemView.getContext())
                .load(ConstantUtil.IMAGE_BAISC+item.Icon)
                .into(icon);
    }
}
