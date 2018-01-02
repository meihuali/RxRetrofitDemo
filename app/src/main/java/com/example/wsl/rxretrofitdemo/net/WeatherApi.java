package com.example.wsl.rxretrofitdemo.net;

import com.example.wsl.rxretrofitdemo.bean.Result;
import com.example.wsl.rxretrofitdemo.bean.WeatherBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wsl on 2018/1/2.
 */

public interface WeatherApi {
    @GET(Constant.GET_WEATHER)
    Observable<Result<WeatherBean>> getWeather(@Query("city") String city);


}
