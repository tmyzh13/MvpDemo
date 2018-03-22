package com.example.issuser.mvpdemo.dagger_mvp_test;

import android.content.Context;

/**
 * Created by issuser on 2018/3/22.
 */

public interface DaggerBaseView {

    void  showLoading();
    void hideloading();
    void  showToast(String msg);
    void showErr();
    Context getContext();
}
