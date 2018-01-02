package com.example.wsl.rxretrofitdemo.net;

import com.example.wsl.rxretrofitdemo.bean.Result;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class SchedulersUtil {

    public static <T> ObservableTransformer<Result<T>, T> judgeResultWithLife(final RxAppCompatActivity activity) {
        return new ObservableTransformer<Result<T>, T>() {

            @Override
            public ObservableSource<T> apply(Observable<Result<T>> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(activity.<Result<T>>bindToLifecycle())
                        .compose(SchedulersUtil.<T>judgeBaseResultReally());
            }
        };

    }

    public static <T> ObservableTransformer<Result<T>, T> judgeBaseResultReally() {

        return new ObservableTransformer<Result<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<Result<T>> upstream) {
                return upstream
                        .map(new GetDataFunc<Result<T>, T>())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


}
