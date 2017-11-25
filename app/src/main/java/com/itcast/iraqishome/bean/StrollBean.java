package com.itcast.iraqishome.bean;

import java.util.ArrayList;

/**
 * Created by yb on 2017/11/25.
 */

public class StrollBean {
    public String Message;
    public String Result;
    public int Status;
    public EntityInfo InnerData;

    public class EntityInfo{
        public int CurPage;
        public int PageCount;
        public ArrayList<ListInfo> StrollList;
    }

    public class ListInfo{
        public int ActType;
        public double ActivityPrice;
        public String BeginDate;
        public int CategoryId;
        public String EndDate;
        public String ImageUrl;
        public int ItemInfoID;
        public String ItemLinkURL;
        public int ItemType;
        public double MarketPrice;
        public String Name;
        public double SalePrice;
        public int SaleQty;
        public int Type;
        public ArrayList<ConfigerInfo> ConfigerList;
    }

    public class ConfigerInfo{
        public int Id;
        public String ImgUrl;
        public String LinkUrl;
        public int Sort;
        public String Title;
    }
}
