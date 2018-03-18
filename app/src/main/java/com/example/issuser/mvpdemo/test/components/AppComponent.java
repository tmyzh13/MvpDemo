package com.example.issuser.mvpdemo.test.components;

import android.content.Context;

import com.example.issuser.mvpdemo.test.Modules.AppModule;
import com.example.issuser.mvpdemo.test.ToastUtil;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by john on 2018/3/18.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Context getContext();
    ToastUtil getToastUtil();
}
