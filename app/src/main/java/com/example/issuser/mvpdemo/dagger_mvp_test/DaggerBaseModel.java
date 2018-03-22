package com.example.issuser.mvpdemo.dagger_mvp_test;

import com.example.issuser.mvpdemo.BaseCallBack;

import java.util.Map;

/**
 * Created by issuser on 2018/3/22.
 */

public abstract class DaggerBaseModel <T>{

    protected void getNetApi(){

    }

    protected void requestGetAPI( BaseCallBack<T> callback){

    }

    protected void requestPostAPI( Map params, BaseCallBack<T> callBack){

    }
}
