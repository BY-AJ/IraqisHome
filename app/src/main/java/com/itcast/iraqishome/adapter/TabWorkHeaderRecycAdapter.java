package com.itcast.iraqishome.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.itcast.iraqishome.R;
import com.itcast.iraqishome.bean.TabWorkBean;
import com.itcast.iraqishome.utills.ConstantUtil;

import java.util.List;

/**
 * Created by yb on 2017/11/17.
 */

public class TabWorkHeaderRecycAdapter extends BaseQuickAdapter<TabWorkBean.CategoryInfo,BaseViewHolder>{

    public TabWorkHeaderRecycAdapter(@Nullable List<TabWorkBean.CategoryInfo> data) {
        super(R.layout.recycler_item_tabwork_header,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TabWorkBean.CategoryInfo item) {
        helper.setText(R.id.tv_header_title,item.Title);
        ImageView ivHeaderIcon = (ImageView)helper.itemView.findViewById(R.id.iv_header_icon);
        Glide.with(helper.itemView.getContext())
                .load(ConstantUtil.IMAGE_BAISC+item.CategoryImageUrl)
                .into(ivHeaderIcon);
    }
}
