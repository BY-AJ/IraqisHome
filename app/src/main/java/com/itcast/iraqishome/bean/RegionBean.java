package com.itcast.iraqishome.bean;

import java.util.ArrayList;

/**
 * Created by yb on 2017/11/25.
 */

public class RegionBean {
    public String Message;
    public String Result;
    public int Status;
    public ArrayList<ProvinceInfo> InnerData;

    public class ProvinceInfo{
        public String Name;
        public ArrayList<CityInfo> Details;
    }

    public class CityInfo{
        public String Name;
        public ArrayList<CountyInfo> Details;
    }

    public class CountyInfo{
        public String Name;
    }
}
