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


}
