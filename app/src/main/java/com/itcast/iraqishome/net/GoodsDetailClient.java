package com.itcast.iraqishome.net;

import com.itcast.iraqishome.bean.GoodsDetailBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yb on 2017/11/21.
 */

public interface GoodsDetailClient {
    @GET("items/itemview")
    Call<GoodsDetailBean> getDataForServer(@Query("Iteminfoid") int Iteminfoid);
}
