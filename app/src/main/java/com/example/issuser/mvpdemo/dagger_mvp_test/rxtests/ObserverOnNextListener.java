package com.example.issuser.mvpdemo.dagger_mvp_test.rxtests;

/**
 * Created by issuser on 2018/3/23.
 */

public interface ObserverOnNextListener<T> {
    void onNext(T data);
    void Error(int code);
    void hideLoading();
}
