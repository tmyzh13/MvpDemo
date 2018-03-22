package com.example.issuser.mvpdemo.dagger_mvp_test;

import com.example.issuser.mvpdemo.BaseCallBack;
import com.example.issuser.mvpdemo.BasePresenter;
import com.example.issuser.mvpdemo.dagger_mvp_test.api.GetDatas;
import com.example.issuser.mvpdemo.utils.ApiFactory;

/**
 * Created by issuser on 2018/3/22.
 */

public class YouDaoPresenter extends DaggerBasePresenter<YouDaoView> {

    private YoudaoDataModel youdaoDataModel;

    @Override
    public void onStart() {
        youdaoDataModel=new YoudaoDataModel();
        youdaoDataModel.getNetApi();
    }

    public void getNetData(){
        getMvpView().showLoading();
        youdaoDataModel.requestGetAPI(new BaseCallBack<String>() {
            @Override
            public void onSuccess(String data) {
                getMvpView().showNetData(data);
            }

            @Override
            public void onFailure(String msg) {
                getMvpView().showToast(msg);
                getMvpView().hideloading();
            }

            @Override
            public void onError() {
                getMvpView().hideloading();
                getMvpView().showErr();
            }

            @Override
            public void onComplete() {
                getMvpView().hideloading();
            }
        });
    }
}
