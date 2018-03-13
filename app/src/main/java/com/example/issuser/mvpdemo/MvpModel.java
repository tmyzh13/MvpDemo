package com.example.issuser.mvpdemo;


import android.os.Handler;

/**
 * Created by issuser on 2018/3/12.
 */

public class MvpModel {

    public  enum Action{
        NORMAL,FAILUER,ERROR
    }

    public static void getNetData(final Action param,final MvpCallback callback){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (param){
                    case NORMAL:
                        callback.onSuccess("请求成功");
                        break;
                    case FAILUER:
                        callback.onFailure("请求失败，参数有误");
                        break;
                    case ERROR:
                        callback.onError();
                        break;
                }
                callback.onComplete();
            }
        },2000);
    }


    public static void getNetData2(final Action action, final BaseCallBack<String> callBack){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (action){
                    case NORMAL:
                        callBack.onSuccess("请求网络数据成功");
                        break;
                    case FAILUER:
                        callBack.onFailure("网络数据解析失败");
                        break;
                    case ERROR:
                        callBack.onError();
                }
            }
        },2000);
    }

}
