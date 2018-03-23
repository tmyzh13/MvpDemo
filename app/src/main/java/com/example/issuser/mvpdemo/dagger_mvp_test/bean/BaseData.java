package com.example.issuser.mvpdemo.dagger_mvp_test.bean;

/**
 * Created by issuser on 2018/3/23.
 */

public class BaseData<T> {

    //接口返回的响应 判断成功或者失败
    private int code;
    //接口返回的错误信息
    private String msg;

    //真正的数据
    private T data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }
}
