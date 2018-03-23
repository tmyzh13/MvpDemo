package com.example.issuser.mvpdemo.dagger_mvp_test;

import com.example.issuser.mvpdemo.BaseView;

/**
 * Created by issuser on 2018/3/22.
 */

public interface YouDaoView extends DaggerBaseView {
    /**
     * 加载网络请求回来的数据
     * @param msg
     */
    void showNetData(String msg);
}
