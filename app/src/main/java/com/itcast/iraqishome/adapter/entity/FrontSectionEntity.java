package com.itcast.iraqishome.adapter.entity;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by yb on 2017/11/17.
 */

public class FrontSectionEntity extends SectionEntity<FrontSectionBean>{

    public FrontSectionEntity(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public FrontSectionEntity(FrontSectionBean frontSectionBean) {
        super(frontSectionBean);
    }
}
