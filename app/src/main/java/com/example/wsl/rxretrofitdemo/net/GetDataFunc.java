package com.example.wsl.rxretrofitdemo.net;

import com.example.wsl.rxretrofitdemo.bean.Result;

import io.reactivex.functions.Function;

public class GetDataFunc<T extends Result, R> implements Function<T, R> {
    @Override
    public R apply(T o) throws Exception {
        R data = null;
        if (o.getStatus() != 200) {
            throw new ResultException(o.getMessage());
        } else {
            data = (R) o.getData();
        }
        return data;
    }
}