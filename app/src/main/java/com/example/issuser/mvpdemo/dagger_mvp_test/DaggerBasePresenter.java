package com.example.issuser.mvpdemo.dagger_mvp_test;

/**
 * Created by issuser on 2018/3/22.
 */

public abstract class DaggerBasePresenter<V extends DaggerBaseView> {

    private V mvpView;

    public void attachView(V mvpView){
        this.mvpView=mvpView;
    }



    public void detachView(){
        this.mvpView=null;
    }

    public boolean isViewAttached(){
        return mvpView!=null;
    }

    public V getMvpView(){
        return mvpView;
    }
    public abstract void onStart();
}
