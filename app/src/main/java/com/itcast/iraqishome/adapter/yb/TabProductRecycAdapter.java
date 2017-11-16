package com.itcast.iraqishome.adapter.yb;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.itcast.iraqishome.R;
import com.itcast.iraqishome.bean.yb.TabProductBean;
import com.itcast.iraqishome.utills.yb.ConstantUtil;

import java.util.List;

/**
 * Created by yb on 2017/11/16.
 */

public class TabProductRecycAdapter extends BaseQuickAdapter<TabProductBean.EntityInfo,BaseViewHolder>{
    public TabProductRecycAdapter(@Nullable List<TabProductBean.EntityInfo> data) {
        super(R.layout.recycler_item_tabproduct,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TabProductBean.EntityInfo item) {
        helper.setText(R.id.tv_tabpro_name,item.Name);
        helper.setText(R.id.tv_tabpro_pricetag,item.PriceTag);
        helper.setText(R.id.tv_tabpro_comment,"评论: "+item.CommentCount);

        ImageView ivIcon =(ImageView)helper.itemView.findViewById(R.id.iv_tabpro_icon);
        Glide.with(helper.itemView.getContext())
                .load(ConstantUtil.IMAGE_BAISC + item.ImageUrl)
                .into(ivIcon);

        if(item.ActivityPrice == 0) {
            helper.setVisible(R.id.tv_tavpro_flag,false);
            helper.setVisible(R.id.tv_tabpro_flag_price,false);
            TextView tvSalePrice = (TextView )helper.itemView.findViewById(R.id.tv_tabpro_sale_price);
            tvSalePrice.setText("￥ "+item.SalePrice);
            tvSalePrice.getPaint().setFlags(0);
            tvSalePrice.setTextColor(Color.parseColor("#000000"));
        }else {
            helper.setVisible(R.id.tv_tavpro_flag,true);
            helper.setVisible(R.id.tv_tabpro_flag_price,true);
            helper.setText(R.id.tv_tabpro_flag_price,"￥ "+item.ActivityPrice);
            TextView tvSalePrice = (TextView )helper.itemView.findViewById(R.id.tv_tabpro_sale_price);
            tvSalePrice.setText("￥ "+item.SalePrice);
            //文字中间加横线
            tvSalePrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
