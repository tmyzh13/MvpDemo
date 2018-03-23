package com.example.issuser.mvpdemo.dagger_mvp_test;

import com.example.issuser.mvpdemo.BaseCallBack;
import com.example.issuser.mvpdemo.BasePresenter;
import com.example.issuser.mvpdemo.dagger_mvp_test.api.GetDatas;
import com.example.issuser.mvpdemo.utils.ApiFactory;

/**
 * Created by issuser on 2018/3/22.
 */

public class YouDaoPresenter extends DaggerBasePresenter<YouDaoView,String> {

    private YoudaoDataModel youdaoDataModel;

    @Override
    public void onStart() {
        youdaoDataModel=new YoudaoDataModel();
        youdaoDataModel.getNetApi();
    }

    public void getNetData(){
        if(!isViewAttached()){
            //已经解绑了
            return;
        }
        getMvpView().showLoading();
        youdaoDataModel.requestGetAPI(this);
    }

    @Override
    public void onSuccess(String data) {
        if(isViewAttached()){
            getMvpView().showNetData(data);
        }
    }

    @Override
    public void onFailure(String msg) {
        if(isViewAttached()){
            getMvpView().showToast(msg);
            getMvpView().hideloading();
        }
    }

    @Override
    public void onError() {
        if(isViewAttached()){
            getMvpView().hideloading();
            getMvpView().showErr();
        }
    }

    @Override
    public void onComplete() {
        if(isViewAttached()){
            getMvpView().hideloading();
        }
    }
}
