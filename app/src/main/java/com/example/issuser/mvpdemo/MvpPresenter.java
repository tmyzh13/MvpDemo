package com.example.issuser.mvpdemo;

/**
 * Created by issuser on 2018/3/12.
 */

public class MvpPresenter {

    //View接口
    private MvpView mvpView;

    public MvpPresenter(MvpView view){
        this.mvpView=view;
    }

    public void getData(MvpModel.Action param){
        mvpView.showLoading();
        MvpModel.getNetData(param, new MvpCallback() {
            @Override
            public void onSuccess(String data) {
                mvpView.showData(data);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.showFailureMessage(msg);
            }

            @Override
            public void onError() {
                mvpView.showErrorMessage();
            }

            @Override
            public void onComplete() {
                mvpView.hideLoading();
            }
        });
    }
}
