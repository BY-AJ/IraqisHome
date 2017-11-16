package com.itcast.iraqishome.bean.yb;

import java.util.ArrayList;

/**
 * Created by yb on 2017/11/16.
 */

public class TabProductBean {
    public String Message;
    public String Result;
    public int Status;
    public ArrayList<EntityInfo> InnerData;

    public class EntityInfo{
        public float ActivityPrice;
        public String ActivityTag;
        public int CommentCount;
        public String ImageUrl;
        public int ItemInfoId;
        public String Name;
        public String PriceTag;
        public float SalePrice;
        public String Uri;
    }
}
