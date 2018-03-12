package com.example.issuser.mvpdemo;

/**
 * Created by issuser on 2018/3/12.
 */

public interface MvpView {
    /**
     * 显示正在加载进度框
     */
    void showLoading();

    /**
     * 隐藏正在加载进入框
     */
    void hideLoading();

    /**
     * 请求数据成功后，调用此接口显示数据
     * @param data
     */
    void showData(String data);

    /**
     * 数据请求失败，调用
     * @param msg
     */
    void showFailureMessage(String msg);

    /**
     * 当数据请求异常，调用此接口提示
     */
    void showErrorMessage();
}
