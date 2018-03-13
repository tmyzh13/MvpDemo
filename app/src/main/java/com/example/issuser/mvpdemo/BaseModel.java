package com.example.issuser.mvpdemo;

import java.util.Map;

import javax.security.auth.callback.Callback;

/**
 * Created by issuser on 2018/3/13.
 */

public abstract class BaseModel<T> {
    protected MvpModel.Action action;

    public BaseModel params(MvpModel.Action action){
        this.action=action;
        return this;
    }

    public abstract void execute(BaseCallBack<T> callBack);
    protected void requestGetAPI(String url, BaseCallBack<T> callback){

    }
    protected void requestPostAPI(String url, Map params,BaseCallBack<T> callBack){

    }
}
