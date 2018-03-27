package com.example.issuser.mvpdemo.dagger_mvp_test;

import android.os.Bundle;

import com.example.issuser.mvpdemo.dagger_mvp_test.testthrea.LifeCycleListener;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by issuser on 2018/3/27.
 */

public  class DaggerBasePresenterNew<V extends DaggerBaseView,T extends DaggerBaseActivity> implements LifeCycleListener {

    private Reference<V> mViewRef;
    private V mvpView;
    private Reference<T> mActivityRef;
    private T mActivity;

    /**
     * 绑定view，在获取网络响应之后通过view传递给activity
     * @param mvpView
     */
    public void attachView(V mvpView){
        mViewRef=new WeakReference<V>(mvpView);
        this.mvpView=mViewRef.get();
    }

    /**
     * 解绑view
     */
    public void detachView(){
        if(isViewAttached()){
            mViewRef.clear();
            this.mvpView=null;
        }

    }

    public void attachActivity(T activity){
        mActivityRef=new WeakReference<T>(activity);
        mActivity=mActivityRef.get();
    }

    public void detachActivity(){
        if(isActivityAttached()){
            mActivityRef.clear();
            mActivity=null;
        }
    }

    public boolean isActivityAttached(){
        return mActivity!=null;
    }

    public T getmActivity(){
        return mActivity;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        detachView();
        detachActivity();
    }
}
