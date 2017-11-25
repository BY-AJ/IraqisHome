package com.itcast.iraqishome.bean;

import java.util.ArrayList;

/**
 * Created by yb on 2017/11/25.
 */

public class LimitedDetailBean {
    public String Message;
    public String Result;
    public int Status;
    public EntityInfo InnerData;

    public class EntityInfo{
        public ArrayList<BannerInfo> HeaderBanners;
        public ArrayList<BodyInfo> Shelves;
    }

    public class BannerInfo{
        public String ImageUrl;
        public int TargetId;
    }

    public class BodyInfo{
        public ArrayList<ItemInfo> Items;
    }

    public class ItemInfo{
        public float ActivityPrice;
        public String Appeal;
        public int Code;
        public int CommentCount;
        public String ImageUrl;
        public int ItemInfoId;
        public String Name;
        public String PriceTag;
        public float SalePrice;
        public String Uri;
    }
}
