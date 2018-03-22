package com.example.issuser.mvpdemo;

import android.os.Handler;

/**
 * Created by issuser on 2018/3/13.
 */

public class UserDataModel extends BaseModel<String> {



    @Override
    public void execute(final BaseCallBack<String> callBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (action){
                    case NORMAL:
                        callBack.onSuccess("请求数据成功");
                        break;
                    case FAILUER:
                        callBack.onFailure("请求数据解析失败");
                        break;
                    case ERROR:
                        callBack.onError();
                        break;
                }
                callBack.onComplete();
            }
        },2000);
    }
}
