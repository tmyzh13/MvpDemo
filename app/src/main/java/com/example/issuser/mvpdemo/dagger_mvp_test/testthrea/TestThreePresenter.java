package com.example.issuser.mvpdemo.dagger_mvp_test.testthrea;

import android.os.Bundle;

import com.example.issuser.mvpdemo.BaseCallBack;
import com.example.issuser.mvpdemo.dagger_mvp_test.BaseCallBackNew;
import com.example.issuser.mvpdemo.dagger_mvp_test.DaggerBasePresenter;
import com.example.issuser.mvpdemo.dagger_mvp_test.DaggerBasePresenterNew;
import com.example.issuser.mvpdemo.dagger_mvp_test.bean.BaseData;
import com.example.issuser.mvpdemo.dagger_mvp_test.bean.UserBean;
import com.trello.rxlifecycle2.components.RxActivity;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by issuser on 2018/3/27.
 */

public class TestThreePresenter extends DaggerBasePresenter<TestThreeView> {


    private TestThreeModel model;

    private RxActivity activity;
    private Reference<RxActivity> mActivityRef;



    @Override
    public void setRxActivity(RxActivity activity) {
        mActivityRef=new WeakReference<RxActivity>(activity);
        this.activity=activity;
    }

    @Override
    public void clearRxActivity() {
        mActivityRef.clear();
        this.activity=null;
    }


    @Override
    public void onStart() {

        model=new TestThreeModel();
        model.getNetApi();

    }



    public void login(String login,String password){
        Map<String,Object> map =new HashMap<>();
        map.put("username",login);
        map.put("password",password);
        map.put("key","1889b37351288");
        getMvpView().showLoading();
        model.requestPostAPI(activity, map, new BaseCallBackNew<UserBean>() {
            @Override
            public void onSuccess(UserBean data) {
                getMvpView().hideloading();
                getMvpView().showUserInfo(data);
            }

            @Override
            public void onFailure(int code, String msg) {
                //可以判断code做操作
                getMvpView().hideloading();
                getMvpView().showToast(msg);
            }

//            @Override
//            public void onNetStart() {
//                getMvpView().showLoading();
//            }
        });
    }

}
