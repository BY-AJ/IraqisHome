package com.itcast.iraqishome.bean;

import java.util.ArrayList;

/**
 * Created by yb on 2017/11/26.
 */

public class ShopBean {
    public ArrayList<EntityInfo> RecommendItems;

    public class EntityInfo{
        public float ActivityPrice;
        public int CommentCount;
        public String ImageUrl;
        public int ItemInfoId;
        public String Name;
        public String PriceTag;
        public float SalePrice;
        public String Uri;
    }
}
