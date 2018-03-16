package com.example.issuser.mvpdemo.daggertest;

import dagger.Component;

/**
 * Created by issuser on 2018/3/16.
 */

@Component(dependencies = AppComponent.class,modules = ActivityMoudule.class)
public interface ActivityComponent {

    // 注入
    void inject(DaggerTest3Activity activity);
}
