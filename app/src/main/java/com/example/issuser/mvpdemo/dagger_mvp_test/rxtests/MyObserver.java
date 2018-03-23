package com.example.issuser.mvpdemo.dagger_mvp_test.rxtests;

import android.content.Context;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by issuser on 2018/3/23.
 */

public class MyObserver<T> implements Observer<T> {

    public static final String TAG="yzhMyObserver";
    private ObserverOnNextListener observerOnNextListener;
    private Context context;

    public MyObserver(Context context,ObserverOnNextListener observerOnNextListener){
        this.observerOnNextListener=observerOnNextListener;
        this.context=context;
    }

    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onNext(T o) {
        observerOnNextListener.onNext(o);
    }

    @Override
    public void onError(Throwable e) {
        observerOnNextListener.hideLoading();
    }

    @Override
    public void onComplete() {
        observerOnNextListener.hideLoading();
    }
}
