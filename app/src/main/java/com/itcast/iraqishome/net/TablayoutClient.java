package com.itcast.iraqishome.net;

import com.itcast.iraqishome.bean.yb.TablayoutBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yb on 2017/11/14.
 */

public interface TablayoutClient {
    @GET("contents/NavgitaionCategories")
    Call<TablayoutBean> getDataForserver();

}
