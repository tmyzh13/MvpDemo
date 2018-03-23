package com.example.issuser.mvpdemo.dagger_mvp_test;

import com.example.issuser.mvpdemo.BaseCallBack;

/**
 * Created by issuser on 2018/3/22.
 */

public abstract class DaggerBasePresenter<V extends DaggerBaseView,T> implements BaseCallBack<T> {

    private V mvpView;

    /**
     * 绑定view，在获取网络响应之后通过view传递给activity
     * @param mvpView
     */
    public void attachView(V mvpView){
        this.mvpView=mvpView;
    }

    /**
     * 解绑view
     */
    public void detachView(){
        this.mvpView=null;
    }

    /**
     * 判断是否解绑 在网络请求时页面被终结，导致后续出现nullpointException
     * @return
     */
    public boolean isViewAttached(){
        return mvpView!=null;
    }

    public V getMvpView(){
        return mvpView;
    }

    /**
     * 在页面对象创建完成后调用，可以用来初始化数据层对象
     */
    public abstract void onStart();
}
