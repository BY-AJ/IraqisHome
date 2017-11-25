package com.itcast.iraqishome.adapter.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.itcast.iraqishome.bean.StrollBean;

/**
 * Created by yb on 2017/11/25.
 */

public class StrollMultiItemEntity implements MultiItemEntity{
    private int type;
    private StrollBean.ListInfo info;

    public static final int TEXT =3;
    public static final int IMG =1;

    public StrollMultiItemEntity(int type, StrollBean.ListInfo info) {
        this.type = type;
        this.info = info;
    }

    @Override
    public int getItemType() {
        return type;
    }

    public StrollBean.ListInfo getInfo(){
        return info;
    }
}
