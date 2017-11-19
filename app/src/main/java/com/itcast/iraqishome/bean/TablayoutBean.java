package com.itcast.iraqishome.bean;

import java.util.ArrayList;

/**
 * Created by yb on 2017/11/14.
 */

public class TablayoutBean {
    public String Message;
    public String Result;
    public int Status;
    public TabInfo InnerData;

    public class TabInfo {
        public ArrayList<EntityInfo> IndexNav;
    }

    public class EntityInfo {
        public String Code;
        public String Name;
        public int ItemIndexId;
        public String Uri;
    }
}
