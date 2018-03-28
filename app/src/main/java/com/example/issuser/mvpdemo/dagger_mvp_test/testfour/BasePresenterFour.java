package com.example.issuser.mvpdemo.dagger_mvp_test.testfour;

import com.trello.rxlifecycle2.components.RxActivity;

/**
 * Created by issuser on 2018/3/28.
 */

public abstract class BasePresenterFour<M extends BaseModelFour,V extends BaseViewFour> {
    private V mvpView;
    private M model;

    /**
     * 绑定view，在获取网络响应之后通过view传递给activity
     * @param mvpView
     */
    public void attachView(V mvpView){
        this.mvpView=mvpView;
    }
    public void attachModel(M model){
        this.model=model;
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

    public abstract void setRxActivity(RxActivity activity);

    public abstract void clearRxActivity();
}
