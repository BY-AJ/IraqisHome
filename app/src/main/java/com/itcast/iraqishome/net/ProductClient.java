package com.itcast.iraqishome.net;

import com.itcast.iraqishome.bean.CategoryBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yb on 2017/11/25.
 */

public interface ProductClient {
    @GET("categories/allCategory")
    Call<CategoryBean> getDataForServer();
}
