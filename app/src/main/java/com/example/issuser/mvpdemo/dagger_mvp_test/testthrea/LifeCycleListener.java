package com.example.issuser.mvpdemo.dagger_mvp_test.testthrea;

import android.os.Bundle;

/**
 * 生命周期监听
 *
 * @author ZhongDaFeng
 * @date 2017/7/15
 */

public interface LifeCycleListener {

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onRestart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

}
