package com.itcast.iraqishome.adapter;

import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.itcast.iraqishome.R;
import com.itcast.iraqishome.adapter.entity.FrontSectionEntity;
import com.itcast.iraqishome.utills.ConstantUtil;

import java.util.List;

/**
 * Created by yb on 2017/11/17.
 */

public class TabFrontRecycAdapter extends BaseSectionQuickAdapter<FrontSectionEntity,BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public TabFrontRecycAdapter(int layoutResId, int sectionHeadResId, List<FrontSectionEntity> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, FrontSectionEntity item) {
        helper.setText(R.id.tv_front_title,item.header);
    }

    @Override
    protected void convert(BaseViewHolder helper, FrontSectionEntity item) {

        helper.setText(R.id.tv_front_name,item.t.Name);
        if(TextUtils.isEmpty(item.t.PriceTag)){
            helper.setVisible(R.id.tv_front_pricetag,false);
        }else {
            helper.setText(R.id.tv_front_pricetag,item.t.PriceTag);
        }
        helper.setText(R.id.tv_front_comment,"评论: "+item.t.CommentCount);

        ImageView ivIcon =(ImageView)helper.itemView.findViewById(R.id.iv_front_icon);
        Glide.with(helper.itemView.getContext())
                .load(ConstantUtil.IMAGE_BAISC + item.t.ImageUrl)
                .into(ivIcon);

        if(item.t.ActivityPrice == 0) {
            helper.setVisible(R.id.tv_front_flag,false);
            helper.setVisible(R.id.tv_front_flag_price,false);
            TextView tvSalePrice = (TextView )helper.itemView.findViewById(R.id.tv_front_sale_price);
            tvSalePrice.setText("￥ "+item.t.SalePrice);
            tvSalePrice.getPaint().setFlags(0);
            tvSalePrice.setTextColor(Color.parseColor("#000000"));
        }else {
            helper.setVisible(R.id.tv_front_flag,true);
            helper.setVisible(R.id.tv_front_flag_price,true);
            helper.setText(R.id.tv_front_flag_price,"￥ "+item.t.ActivityPrice);
            TextView tvSalePrice = (TextView )helper.itemView.findViewById(R.id.tv_front_sale_price);
            tvSalePrice.setText("￥ "+item.t.SalePrice);
            //文字中间加横线
            tvSalePrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
