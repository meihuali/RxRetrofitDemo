package com.example.wsl.rxretrofitdemo.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * retrofit的一些配置
 */
public class RetrofitConfig {
    private RetrofitConfig() {
    }

    public static final int TIMEOUT = 60;
    private static OkHttpClient mClient;
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getClient())
            .build();

    public static <T> T createApiService(Class<T> ApiService) {
        return retrofit.create(ApiService);
    }


    private static OkHttpClient getClient() {
        if (mClient != null) {
            return mClient;
        }
        return new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build();
    }
}
