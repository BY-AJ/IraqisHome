package com.itcast.iraqishome.bean;

import java.util.ArrayList;

/**
 * Created by yb on 2017/11/21.
 */

public class GoodsDetailBean {
    public String Message;
    public String Result;
    public int Status;
    public EntityInfo InnerData;

    public class EntityInfo{
        public String Caption;
        public String Name;
        public int SalePrice;

        public ArrayList<HeaderInfo> Headers;
        public ArrayList<BuyInfo> BuyWith;
        //public ArrayList<GroupInfo> GroupAttrs;
        public ArrayList<ServiceInfo> ServiceIcon;
        public ArrayList<DetailInfo> Details;
        public ArrayList<SpecInfo> Specifications;
    }

    /*********************头部图片信息类********************/
    public class HeaderInfo {
        public String ImageUrl;
    }
    /********************************************************/

    /*************************种类属性信息类**********************/
    public class GroupInfo {
        public ArrayList<PropsInfo> props;
        public String selSku;

    }

    public class PropsInfo{
        public String pname;
        public int pid;
        public String descF5;
        public int imgPrev;
        public ArrayList<ValInfo> vals;
    }

    public class ValInfo{
        public int vid;
        public String vname;
    }
    /***************************************************************/


    /*********************还有更多可选信息类*************************/
    public class BuyInfo{
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
    /***************************************************************/

    /*******************服务承诺信息类******************************/
    public class ServiceInfo{
        public String ImageUrl;
        public int ImageHeight;
        public int ImageWidth;
        public ArrayList<TouchInfo> TouchElem;
    }

    public class TouchInfo{
        public String Uri;
        public int BeginXP;
        public int BeginYP;
        public int EndXP;
        public int EndYP;
    }
    /***************************************************************/

    /***********************商品介绍信息类**************************/
    public class DetailInfo {
        public String ImageUrl;
    }
    /***************************************************************/

    /************************规格参数信息类************************/
    public class SpecInfo {
        public String Name;
        public String Value;
    }
    /***************************************************************/
}
