package com.example.issuser.mvpdemo.dagger_mvp_test.rxtests;

import android.content.Context;
import android.util.Log;

import com.example.issuser.mvpdemo.dagger_mvp_test.DaggerBaseView;
import com.example.issuser.mvpdemo.dagger_mvp_test.bean.BaseData;
import com.example.issuser.mvpdemo.dagger_mvp_test.exceptions.ApiException;
import com.example.issuser.mvpdemo.dagger_mvp_test.exceptions.ExceptionEngine;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 考虑是否要直接加入view
 * Created by issuser on 2018/3/26.
 */

public abstract class BaseObserver<T> implements Observer<BaseData<T>> {

    private final String TAG="yzhBaseObserver";
    private final int RESPONSE_CODE_OK=0;
    private final int RESPONSE_CODE_FAIL=-1;
    private Context mContext;
    private static Gson gson =new Gson();
    private int errorCode;
    private String errorMsg="未知的错误";
    private DaggerBaseView view;
    private String tag;

    /**
     * 在具体的业务里需要实现的
     * @param t
     */
    protected abstract void onSuccess(T t);
    protected abstract void onFail(ApiException e);

    public BaseObserver(Context mContext,DaggerBaseView view){
        this.mContext =mContext;
        this.view=view;
        this.tag=this.getClass().getName();
        Log.e("yzh","tag=="+tag);
    }

    @Override
    public void onSubscribe(Disposable d) {
        view.showLoading();
        RxActionManagerImpl.getInstance().add(tag, d);
    }

    @Override
    public void onNext(BaseData<T> tBaseData) {
        view.hideloading();
        RxActionManagerImpl.getInstance().remove(tag);
        //在observable map方法中过滤过一次 这里应该只走到true 两种方式 做一个备选方案
        if(tBaseData.getCode()==RESPONSE_CODE_OK){
            onSuccess(tBaseData.getData());
        }else{
            onFail(new ApiException(tBaseData.getCode(),tBaseData.getMsg()));
        }
    }
    @Override
    public void onComplete() {
        view.hideloading();
    }

    /**
     * 转化统一的异常 方便输出
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        RxActionManagerImpl.getInstance().remove(tag);
        if(e instanceof ApiException){
            onFail((ApiException) e);
        }else{
            onFail(new ApiException(e, ExceptionEngine.UN_KNOWN_ERROR));
        }
    }

    /**
     * 暂时只记录了两个异常 可以对后面其他情况增加
     */
//    @Override
//    public void onError(Throwable e) {
//        view.hideloading();
//        if(e instanceof HttpException){
//            HttpException httpException=(HttpException)e;
//            errorCode=httpException.code();
//            errorMsg=httpException.message();
//        }else if(e instanceof SocketTimeoutException){
//            errorCode=RESPONSE_CODE_FAIL;
//            errorMsg="服务器响应超时";
//        }
//        onFail(errorCode,errorMsg);
//    }

//    public void onFail(int code,String errorMsg){
//      view.showToast(errorMsg);
//    }
}
