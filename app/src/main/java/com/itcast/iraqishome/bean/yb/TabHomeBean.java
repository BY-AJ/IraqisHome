package com.itcast.iraqishome.bean.yb;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by yb on 2017/11/15.
 */

public class TabHomeBean {
    public String Message;
    public boolean Result;
    public int Status;
    public Array[] InnerData;

    public class HomeInfo{
        public String Type;
        public int SortIndex;
        public ArrayList<EntityInfo> InnerData;
    }

    public class EntityInfo{
        public String ImageUrl;
        public String Uri;
        public ArrayList<TouchElemInfo> TouchElem;
    }

    public class TouchElemInfo {
        public String Uri;
    }
}
