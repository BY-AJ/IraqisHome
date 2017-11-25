package com.itcast.iraqishome.net;

import com.itcast.iraqishome.bean.LimitedDetailBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yb on 2017/11/25.
 */

public interface LimitedClient {
    @GET("activities/ActivityShelf?code=ExhTopicsubject070113")
    Call<LimitedDetailBean> getDataForServer();
}
