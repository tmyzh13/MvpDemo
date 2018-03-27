package com.example.issuser.mvpdemo.dagger_mvp_test;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.trello.rxlifecycle2.components.RxFragment;

/**
 * Created by issuser on 2018/3/27.
 */

public abstract class DaggerBaseFragment<V extends DaggerBaseView,T extends DaggerBasePresenter<V>>
        extends RxFragment implements DaggerBaseView {

    private View parenteView;
    protected T presenter;

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parenteView = getLayoutInflater().inflate(getLayoutId(), null, false);
    }
    public T getPresenter() {
        return presenter;
    }

    public View getParentView() {
        return parenteView;
    }
    /**
     * 指定Fragment需加载的布局ID
     *
     * @return 需加载的布局ID
     */
    protected abstract int getLayoutId();

    /**
     * 初始化方法, 类似OnCreate, 仅在此方法中做初始化操作, findView与事件绑定请使用ButterKnife
     */
    protected abstract void init(Bundle savedInstanceState);

    /**
     * 创建Presenter, 然后通过调用{@link #getPresenter()}来使用生成的Presenter
     * @return Presenter
     */
    protected abstract T createPresenter();


    @Override
    public void showLoading() {

    }

    @Override
    public void hideloading() {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showErr() {

    }
}
