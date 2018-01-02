package com.example.wsl.rxretrofitdemo.net;


/**
 * 提供apiService
 */
public class RetrofitClient {
    public static WeatherApi getWeatherApi() {
        return RetrofitConfig.createApiService(WeatherApi.class);
    }
}
