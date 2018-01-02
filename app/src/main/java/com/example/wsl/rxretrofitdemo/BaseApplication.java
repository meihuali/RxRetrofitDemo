package com.example.wsl.rxretrofitdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by wsl on 2018/1/2.
 */

public class BaseApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
