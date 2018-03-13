package com.example.issuser.mvpdemo;

/**
 * Created by issuser on 2018/3/13.
 */

public class BasePresenter<V extends BaseView> {

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
}
