package com.itcast.iraqishome.adapter;

import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.itcast.iraqishome.R;
import com.itcast.iraqishome.adapter.entity.StrollMultiItemEntity;
import com.itcast.iraqishome.utills.ConstantUtil;

import java.util.List;

/**
 * Created by yb on 2017/11/25.
 */

public class StrollRecycAdapter extends BaseMultiItemQuickAdapter<StrollMultiItemEntity,BaseViewHolder>{

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public StrollRecycAdapter(List<StrollMultiItemEntity> data) {
        super(data);
        addItemType(StrollMultiItemEntity.TEXT, R.layout.recycler_multi_text);
        addItemType(StrollMultiItemEntity.IMG,R.layout.recycler_multi_image);
    }

    @Override
    protected void convert(BaseViewHolder helper, StrollMultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case StrollMultiItemEntity.TEXT:
                loadText(helper,item);
                break;
            case StrollMultiItemEntity.IMG:
                loadImage(helper,item);
                break;
            default:
                break;
        }
    }

    private void loadText(BaseViewHolder helper, StrollMultiItemEntity item) {
        Button[] btn =new Button[6];
        btn[0] = helper.itemView.findViewById(R.id.btn_stroll1);
        btn[1] = helper.itemView.findViewById(R.id.btn_stroll2);
        btn[2] = helper.itemView.findViewById(R.id.btn_stroll3);
        btn[3] = helper.itemView.findViewById(R.id.btn_stroll4);
        btn[4] = helper.itemView.findViewById(R.id.btn_stroll5);

        for (int i=0;i<item.getInfo().ConfigerList.size();i++) {
            btn[i].setText(item.getInfo().ConfigerList.get(i).Title);
        }

        helper.addOnClickListener(R.id.btn_stroll1)
                .addOnClickListener(R.id.btn_stroll2)
                .addOnClickListener(R.id.btn_stroll3)
                .addOnClickListener(R.id.btn_stroll4)
                .addOnClickListener(R.id.btn_stroll5);
    }

    private void loadImage(BaseViewHolder helper, StrollMultiItemEntity item) {
        helper.setText(R.id.tv_stroll_title,item.getInfo().Name);
        helper.setText(R.id.tv_stroll_price,"￥ "+item.getInfo().SalePrice);
        helper.setText(R.id.tv_stroll_sale,"月销:"+item.getInfo().SaleQty);
        ImageView icon = helper.itemView.findViewById(R.id.iv_stroll_pic);
        Glide.with(helper.itemView.getContext())
                .load(ConstantUtil.IMAGE_BAISC+item.getInfo().ImageUrl)
                .into(icon);
    }
}
