package com.example.wsl.rxretrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wsl.rxretrofitdemo.bean.WeatherBean;
import com.example.wsl.rxretrofitdemo.net.BaseObserver;
import com.example.wsl.rxretrofitdemo.net.RetrofitClient;
import com.example.wsl.rxretrofitdemo.net.SchedulersUtil;
import com.trello.rxlifecycle2.components.RxActivity;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.ResourceObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends RxAppCompatActivity implements View.OnClickListener {

    private Button mBtnGetWeather;
    private TextView mTvWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnGetWeather = findViewById(R.id.btn_get_weather);
        mTvWeather = findViewById(R.id.tv_weather);

        mBtnGetWeather.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        RetrofitClient.getWeatherApi()
                .getWeather("广州")
                .delay(2, TimeUnit.SECONDS)
                .compose(SchedulersUtil.<WeatherBean>judgeResultWithLife(this))
                .subscribe(new BaseObserver<WeatherBean>(this) {
                    @Override
                    protected void onSuccess(WeatherBean value) {
                        mTvWeather.setText(String.format("%s\n质量:%s\n温度:%s", value.getGanmao(), value.getQuality(), value.getWendu()));
                    }
                });
    }
}
