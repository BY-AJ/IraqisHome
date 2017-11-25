package com.itcast.iraqishome.bean;

import java.util.ArrayList;

/**
 * Created by yb on 2017/11/25.
 */

public class CategoryBean {
    public String Message;
    public String Result;
    public int Status;
    public ArrayList<ChildInfo> InnerData;

    public class ChildInfo{
        public ArrayList<EntityInfo> Children;
        public String Name;
        public int ItemIndexId;
    }

    public class EntityInfo{
        public String Name;
        public int ItemIndexId;
        public String Icon;
    }
}
