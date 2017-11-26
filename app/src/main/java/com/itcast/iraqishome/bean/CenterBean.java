package com.itcast.iraqishome.bean;

import java.util.ArrayList;

/**
 * Created by yb on 2017/11/26.
 */

public class CenterBean {
    public String Message;
    public String Result;
    public int Status;
    public EntityInfo InnerData;

    public class EntityInfo{
        public ArrayList<MenuInfo> CenterMenus;
    }

    public class MenuInfo{
        public int FootMargin;
        public int HeadMargin;
        public ArrayList<ItemInfo> Menus;
    }

    public class ItemInfo{
        public String Code;
        public String Icon;
        public String Title;
        public boolean NeedLogin;
    }
}
