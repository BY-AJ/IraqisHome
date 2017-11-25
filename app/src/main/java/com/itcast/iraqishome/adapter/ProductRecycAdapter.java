package com.itcast.iraqishome.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.itcast.iraqishome.R;
import com.itcast.iraqishome.adapter.entity.ProductSectionEntity;
import com.itcast.iraqishome.utills.ConstantUtil;

import java.util.List;

/**
 * Created by yb on 2017/11/25.
 */

public class ProductRecycAdapter extends BaseSectionQuickAdapter<ProductSectionEntity,BaseViewHolder>{

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public ProductRecycAdapter(int layoutResId, int sectionHeadResId, List<ProductSectionEntity> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, ProductSectionEntity item) {
        helper.setText(R.id.tv_front_title,item.header);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductSectionEntity item) {
        helper.setText(R.id.tv_product_title,item.t.Name);
        ImageView icon = (ImageView)helper.itemView.findViewById(R.id.iv_product_icon);
        Glide.with(helper.itemView.getContext())
                .load(ConstantUtil.IMAGE_BAISC+item.t.Icon)
                .into(icon);
    }
}
