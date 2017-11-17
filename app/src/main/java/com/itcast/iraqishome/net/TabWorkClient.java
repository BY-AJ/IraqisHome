package com.itcast.iraqishome.net;

import com.itcast.iraqishome.bean.TabWorkBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yb on 2017/11/17.
 */

public interface TabWorkClient {
    @GET("Categories/Category")
    Call<TabWorkBean> getDataForServer(@Query("itemIndexId") int itemIndexId);
}
