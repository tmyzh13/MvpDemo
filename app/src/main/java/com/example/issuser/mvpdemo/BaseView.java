package com.example.issuser.mvpdemo;

import android.content.Context;

/**
 * Created by issuser on 2018/3/13.
 */

public interface BaseView {

    void  showLoading();
    void hideloading();
    void  showToast(String msg);
    void showErr();
    Context getContext();

}
