package com.example.issuser.mvpdemo.daggertest;

import dagger.Component;

/**
 * Created by issuser on 2018/3/15.
 */

@Component(modules = MainModule.class) //做桥梁 沟通调用者和依赖对象库
public interface MainComponent {

    //定义注入的方法
    void inject(DaggerTestActivity activity);

}
