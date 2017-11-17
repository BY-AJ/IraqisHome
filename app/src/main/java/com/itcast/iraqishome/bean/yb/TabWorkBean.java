package com.itcast.iraqishome.bean.yb;

import java.util.ArrayList;

/**
 * Created by yb on 2017/11/17.
 */

public class TabWorkBean {
    public String Message;
    public String Result;
    public int Status;
    public EntityInfo InnerData;

    public class EntityInfo{
        public int ItemIndexId;
        public String ItemIndexName;
        public String ScreenItemColor;
        public CEORecommend CEORecommendTitle;
        public ArrayList<CEORecommendsInfo> CEORecommends;
        public ArrayList<CategoryInfo> Categories;
    }

    public class CEORecommend {
        public String Text;
    }

    public class CEORecommendsInfo{
        public double ActivityPrice;
        public String Appeal;
        public String Code;
        public int CommentCount;
        public String ImageUrl;
        public int ItemInfoId;
        public String Name;
        public String PriceTag;
        public double SalePrice;
        public String Uri;
    }

    public class CategoryInfo{
        public String CategoryImageUrl;
        public int ItemIndexId;
        public ArrayList<ItemInfo> Items;
        public String Title;
    }

    public class ItemInfo {
        public double ActivityPrice;
        public String ActivityTag;
        public String Appeal;
        public String Code;
        public int CommentCount;
        public String ImageUrl;
        public int ItemInfoId;
        public String Name;
        public double SalePrice;
        public String Uri;
    }
}
