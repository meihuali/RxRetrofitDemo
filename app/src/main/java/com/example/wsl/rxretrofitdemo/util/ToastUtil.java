package com.example.wsl.rxretrofitdemo.util;

import android.text.TextUtils;
import android.widget.Toast;

import com.example.wsl.rxretrofitdemo.BaseApplication;
import com.example.wsl.rxretrofitdemo.BuildConfig;

/**
 * Created by wsl on 2017/4/26.
 */

public class ToastUtil {

    private static Toast toast;

    public static void show(String msg) {
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.getContext(), msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg == null ? "" : msg);
        }
        if (!TextUtils.isEmpty(msg)){
            toast.show();
        }
    }

    public static void showLong(String msg) {
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.getContext(), msg, Toast.LENGTH_LONG);
        } else {
            toast.setText(msg == null ? "" : msg);
        }
        if (!TextUtils.isEmpty(msg)){
            toast.show();
        }
    }

    public static void show(int msg) {
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.getContext(), String.valueOf(msg), Toast.LENGTH_SHORT);
        } else {
            toast.setText(String.valueOf(msg));
        }
        toast.show();
    }
    public static void showDebug(int msg) {
        if (!BuildConfig.DEBUG)return;
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.getContext(), String.valueOf(msg), Toast.LENGTH_SHORT);
        } else {
            toast.setText(String.valueOf(msg));
        }
        toast.show();
    }

    public static void showDebug(String msg) {
        if (!BuildConfig.DEBUG)return;
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.getContext(), msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg == null ? "" : msg);
        }
        if (!TextUtils.isEmpty(msg)){
            toast.show();
        }
    }

}
