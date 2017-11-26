package com.itcast.iraqishome.net;

import com.itcast.iraqishome.bean.CenterBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yb on 2017/11/26.
 */

public interface CenterClient {
    @GET("contents/usercenter")
    Call<CenterBean> getDataForServer();
}
