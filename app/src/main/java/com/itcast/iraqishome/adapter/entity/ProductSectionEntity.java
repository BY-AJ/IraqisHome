package com.itcast.iraqishome.adapter.entity;

import com.chad.library.adapter.base.entity.SectionEntity;
import com.itcast.iraqishome.bean.CategoryBean;

/**
 * Created by yb on 2017/11/25.
 */

public class ProductSectionEntity extends SectionEntity<CategoryBean.EntityInfo>{

    public ProductSectionEntity(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public ProductSectionEntity(CategoryBean.EntityInfo entityInfo) {
        super(entityInfo);
    }
}
