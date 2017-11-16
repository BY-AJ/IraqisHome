package com.itcast.iraqishome.net;

import com.itcast.iraqishome.bean.yb.TabProductBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yb on 2017/11/16.
 */

public interface TabProductClient {
    @GET("contents/newarrival?code=weekly")
    Call<TabProductBean> getDataForServer();
}
