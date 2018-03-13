package com.example.issuser.mvpdemo;

/**
 * Created by issuser on 2018/3/13.
 *
 */

public class MvpPresenter2 {
    //但是在请求过程中当前Activity突然因为某种原因被销毁，Presenter收到后台反馈并调用View接口处理UI逻辑时由于Activity已经被销毁，就会引发空指针异常。

//    想要避免这种情况的发生就需要每次调用View前都知道宿主Activity的生命状态。


    private MvpView mvpView;

    public MvpPresenter2(){

    }

    public void attachView(MvpView mvpView){
        this.mvpView=mvpView;
    }

    public void detachView(){
        this.mvpView=null;
    }

    public boolean isViewAttached(){
        return mvpView!=null;
    }

    public void getData(MvpModel.Action action){
        mvpView.showLoading();
        MvpModel.getNetData(action, new MvpCallback() {
            @Override
            public void onSuccess(String data) {
                if(isViewAttached()){
                    mvpView.showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                if(isViewAttached()){
                    mvpView.showFailureMessage(msg);
                }
            }

            @Override
            public void onError() {
                if(isViewAttached()){
                    mvpView.showErrorMessage();
                }
            }

            @Override
            public void onComplete() {
                if(isViewAttached()){
                    mvpView.hideLoading();
                }
            }
        });
    }

}
