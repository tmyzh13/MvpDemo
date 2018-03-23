package com.example.issuser.mvpdemo.dagger_mvp_test;

import android.content.Context;

/**
 * Created by issuser on 2018/3/22.
 */

public interface DaggerBaseView {

    /**
     * 显示网络请求加载转圈
     */
    void  showLoading();

    /**
     * 关闭加载转圈
     */
    void hideloading();

    /**
     * 吐息一些信息
     * @param msg
     */
    void  showToast(String msg);
    void showErr();
    Context getContext();
}
