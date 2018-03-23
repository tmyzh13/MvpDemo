package com.example.issuser.mvpdemo.dagger_mvp_test;

import com.example.issuser.mvpdemo.BaseCallBack;

import java.util.Map;

/**
 * Created by issuser on 2018/3/22.
 */

public interface DaggerBaseModel <T>{
    /**
     * 创建接口对象
      */
    void getNetApi();

    /**
     * 发送get请求
     * @param callback
     */
     void requestGetAPI( BaseCallBack<T> callback);

    /**
     * 发送post请求
     * @param params
     * @param callBack
     */
    void requestPostAPI( Map params, BaseCallBack<T> callBack);
}
