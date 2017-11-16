package com.itcast.iraqishome.net;

import com.itcast.iraqishome.bean.yb.TabHomeBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yb on 2017/11/15.
 */

public interface TabHomeClient {
    @GET("contents/home_v2")
    Call<TabHomeBean> getDataForServer();
}
