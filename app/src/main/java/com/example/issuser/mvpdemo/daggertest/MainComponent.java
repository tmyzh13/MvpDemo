package com.example.issuser.mvpdemo.daggertest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by issuser on 2018/3/15.
 */
@Singleton
@Component(modules = MainModule.class) //做桥梁 沟通调用者和依赖对象库
public interface MainComponent {

    //这里尝试用泛型的方式写入参数 运行出错  DaggerxxComponent这个类似乎无法生成
    //定义注入的方法
    void inject(DaggerTestActivity activity);

    void inject(DaggerTest2Activity activity);
}
