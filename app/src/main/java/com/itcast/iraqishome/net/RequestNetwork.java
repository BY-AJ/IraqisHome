package com.itcast.iraqishome.net;

import com.itcast.iraqishome.bean.CategoryBean;
import com.itcast.iraqishome.bean.GoodsDetailBean;
import com.itcast.iraqishome.bean.LimitedDetailBean;
import com.itcast.iraqishome.bean.StrollBean;
import com.itcast.iraqishome.bean.TabHomeBean;
import com.itcast.iraqishome.bean.TabProductBean;
import com.itcast.iraqishome.bean.TabWorkBean;
import com.itcast.iraqishome.bean.TablayoutBean;
import com.itcast.iraqishome.utills.ConstantUtil;

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

    public static Call<TabHomeBean> getTabHomeClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(httpClient.build())
                .build();
        TabHomeClient client = retrofit.create(TabHomeClient.class);
        return client.getDataForServer();
    }

    public static Call<TabProductBean> getTabProductClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(httpClient.build())
                .build();
        TabProductClient client = retrofit.create(TabProductClient.class);
        return client.getDataForServer();
    }

    public static Call<TabWorkBean> getTabWorkClient(int id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(httpClient.build())
                .build();
        TabWorkClient client = retrofit.create(TabWorkClient.class);
        return client.getDataForServer(id);
    }

    public static Call<GoodsDetailBean> getGoodsDetailClient(int id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(httpClient.build())
                .build();
        GoodsDetailClient client = retrofit.create(GoodsDetailClient.class);
        return client.getDataForServer(id);
    }

    public static Call<CategoryBean> getProductClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APP_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(httpClient.build())
                .build();
        ProductClient client = retrofit.create(ProductClient.class);
        return client.getDataForServer();
    }

    public static Call<StrollBean> getStrollClient(int pageNo) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantUtil.STROLL_BASIC)
                .addConverterFactory(gsonConverterFactory)
                .client(httpClient.build())
                .build();
        StrollClient client = retrofit.create(StrollClient.class);
        return client.getDataForServer(pageNo);
    }

    public static Call<LimitedDetailBean> getLimitedClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantUtil.STROLL_BASIC)
                .addConverterFactory(gsonConverterFactory)
                .client(httpClient.build())
                .build();
        LimitedClient client = retrofit.create(LimitedClient.class);
        return client.getDataForServer();
    }
}
