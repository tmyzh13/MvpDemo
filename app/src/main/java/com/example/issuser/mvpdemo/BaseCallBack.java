package com.example.issuser.mvpdemo;

/**
 * Created by issuser on 2018/3/13.
 * 传入泛型，来解决onSuccess中参数类型不固定的问题
 */

public interface BaseCallBack<T> {

    void onSuccess(T data);
    void onFailure(String msg);
    void onError();
    void onComplete();
}
