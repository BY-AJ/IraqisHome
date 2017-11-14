package com.itcast.iraqishome.net;

import com.itcast.iraqishome.bean.yb.TablayoutBean;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yb on 2017/11/14.
 */

public class RequestNetwork {
    private static final String APP_URL="http://app.lifevc.com/1.0/v_and_5.1.2_33/";
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();

    public static Call<TablayoutBean> getTablayoutClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(httpClient.build())
                .build();
        TablayoutClient client = retrofit.create(TablayoutClient.class);
        return client.getDataForserver();
    }
}
