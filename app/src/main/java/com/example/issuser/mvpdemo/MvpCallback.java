package com.example.issuser.mvpdemo;

/**
 * Created by issuser on 2018/3/12.
 */

public interface MvpCallback {

    /**
     * 数据请求成功
     * @param data
     */
    void onSuccess(String data);

    /**
     * 数据请求成功 解析失败
     * @param msg
     */
    void onFailure(String msg);

    /**
     * 数据请求失败
     */
    void onError();

    /**
     * 一次请求完成 不管成功或者失败
     */
    void onComplete();
}
