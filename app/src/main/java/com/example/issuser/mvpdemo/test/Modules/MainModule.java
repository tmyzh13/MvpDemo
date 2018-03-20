package com.example.issuser.mvpdemo.test.Modules;

import com.example.issuser.mvpdemo.test.data.GetUserData;

import dagger.Module;
import dagger.Provides;

/**
 * 只是注解的话可以省掉module 第三方的一些类需要用到
 * Created by john on 2018/3/18.
 */

@Module
public class MainModule {

    @Provides
    public GetUserData provideUserData(){
        return new GetUserData();
    }
}
