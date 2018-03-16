package com.example.issuser.mvpdemo.daggertest;

import android.content.Context;

import dagger.Component;

/**
 * Created by issuser on 2018/3/16.
 */

@Component(modules = AppModule.class)
public interface AppComponent {

    //向其下层提供Context对象
    Context proContext();

}
