package com.itcast.iraqishome.net;

import com.itcast.iraqishome.bean.StrollBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yb on 2017/11/25.
 */

public interface StrollClient {
    @GET("Stroll/StrollItemList")
    Call<StrollBean> getDataForServer(@Query("pageNo") int pageNo);
}
