package com.itcast.iraqishome.net;

import com.itcast.iraqishome.bean.ShopBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yb on 2017/11/26.
 */

public interface ShopClient {
    @GET("getCart?si=&ck=923d0a5e_169050810")
    Call<ShopBean> getDataForServer();
}
