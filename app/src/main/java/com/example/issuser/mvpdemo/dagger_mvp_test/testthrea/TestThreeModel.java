package com.example.issuser.mvpdemo.dagger_mvp_test.testthrea;

import android.util.Log;

import com.example.issuser.mvpdemo.BaseCallBack;
import com.example.issuser.mvpdemo.BaseView;
import com.example.issuser.mvpdemo.dagger_mvp_test.BaseCallBackNew;
import com.example.issuser.mvpdemo.dagger_mvp_test.DaggerBaseModelNew;
import com.example.issuser.mvpdemo.dagger_mvp_test.DaggerBaseView;
import com.example.issuser.mvpdemo.dagger_mvp_test.api.TestApi;
import com.example.issuser.mvpdemo.dagger_mvp_test.bean.BaseData;
import com.example.issuser.mvpdemo.dagger_mvp_test.bean.UserBean;
import com.example.issuser.mvpdemo.dagger_mvp_test.exceptions.ApiException;
import com.example.issuser.mvpdemo.dagger_mvp_test.rxtests.BaseObserver;
import com.example.issuser.mvpdemo.utils.ApiFactory;
import com.example.issuser.mvpdemo.utils.ApiMethod;
import com.trello.rxlifecycle2.components.RxActivity;

import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by issuser on 2018/3/27.
 */

public class TestThreeModel implements DaggerBaseModelNew {

    private TestApi api;

    @Override
    public void getNetApi() {
        api= ApiFactory.getInstance().create(TestApi.class);
    }

    public void requestGetAPI(RxActivity activity,BaseCallBack callback) {
    }

    public void requestPostAPI(RxActivity activity, Map params, final BaseCallBackNew<UserBean> callBack) {
        ApiMethod.getObservable(api.login(params),activity)
                .subscribe(new BaseObserver<UserBean>("login") {

                    @Override
                    protected void onSuccess(UserBean bean) {
                        Log.e("yzh","data--"+bean.toString());
                        callBack.onSuccess(bean);
                    }

                    @Override
                    protected void onFail(ApiException e) {
                        //可以根据不同的code做不同的逻辑处理
                        Log.e("yzh","code--"+e.getCode());
                        callBack.onFailure(e.getCode(),e.getMsg());
                    }

//                    @Override
//                    protected void onNetStart() {
//                        callBack.onNetStart();
//                    }
                });
    }
}
