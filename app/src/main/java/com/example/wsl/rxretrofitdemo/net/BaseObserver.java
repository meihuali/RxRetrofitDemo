package com.example.wsl.rxretrofitdemo.net;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ParseException;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.example.wsl.rxretrofitdemo.util.ToastUtil;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.lang.ref.WeakReference;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;

public abstract class BaseObserver<T> extends ResourceObserver<T> {
    //对应HTTP的状态码
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;
    private boolean mShowLoadingDialog = true;
    private WeakReference<Context> mContextWeakReference;
    private AlertDialog mDialog;

    public BaseObserver() {
        mShowLoadingDialog = false;
    }

    protected BaseObserver(FragmentActivity context) {
        mContextWeakReference = new WeakReference<Context>(context);
    }


    protected BaseObserver(FragmentActivity context, boolean showLoadingDialog) {
        mContextWeakReference = new WeakReference<Context>(context);
        this.mShowLoadingDialog = showLoadingDialog;

    }

    @Override
    public void onNext(T value) {
        onSuccess(value);
    }

    protected abstract void onSuccess(T value);

    @Override
    public void onError(Throwable e) {
        Throwable throwable = e;
        //获取最根源的异常
        while (throwable.getCause() != null) {
            e = throwable;
            throwable = throwable.getCause();
        }
        if (e instanceof SocketTimeoutException) {
            ToastUtil.show("请求超时,请检查您的网络.");
        } else if (e instanceof HttpException) {             //HTTP错误
            HttpException httpException = (HttpException) e;
            switch (httpException.code()) {
                case NOT_FOUND:
                    ToastUtil.show("访问网络失败");
                    break;
                case UNAUTHORIZED:
                case FORBIDDEN:
                    break;
                case REQUEST_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                    break;
                case GATEWAY_TIMEOUT:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    ToastUtil.show("访问网络失败");
                    break;
            }
        } else if (e instanceof ResultException) {    //服务器返回的错误
            ResultException resultException = (ResultException) e;
            onServerError(resultException);
        } else if (e instanceof JsonParseException || e instanceof JSONException || e instanceof ParseException) {
            ToastUtil.show("数据解析错误");
        } else if (e instanceof ConnectException) {             //如网络关闭
            ToastUtil.show("哎呀,网络连接有问题～");
        } else if (e instanceof NullPointerException) {             //如网络关闭
            if (e.getMessage() != null) {
                Log.d("RxJava", e.getMessage());
            }
        } else {
            ToastUtil.show("发生未知错误");
        }
        onComplete();
    }

    /**
     * 可重写此方法,自己处理服务器异常.
     *
     * @param resultException
     */
    protected void onServerError(ResultException resultException) {
        ToastUtil.show(resultException.getMessage());
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mShowLoadingDialog) {
            showLoadingDialog();
        }
    }

    @Override
    public void onComplete() {
        hideDialog();
    }

    private void showLoadingDialog() {
        if (mContextWeakReference.get() == null)
            return;
        if (mDialog == null) {
            mDialog = new AlertDialog.Builder(mContextWeakReference.get())
                    .setMessage(setDiaLogMessage())
                    .setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            hideDialog();
                            if (!BaseObserver.this.isDisposed()) {
                                BaseObserver.this.dispose();
                            }
                            ToastUtil.show("取消网络请求");
                        }
                    }).create();
        }
        if (!isFinish()) {
            mDialog.show();
        }
    }

    protected String setDiaLogMessage() {
        return "网络请求中...";
    }

    private void hideDialog() {
        if (!mShowLoadingDialog) {
            return;
        }
        if (isFinish()) {
            return;
        }
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    /**
     * 判断Dialog所依附的Activity或者Fragment是否被销毁
     *
     * @return true 被销毁，false 未销毁
     */
    private boolean isFinish() {
        if (mContextWeakReference == null) {
            return true;
        }
        Context context = mContextWeakReference.get();
        return !(context instanceof Activity) || ((Activity) context).isDestroyed();
    }

}