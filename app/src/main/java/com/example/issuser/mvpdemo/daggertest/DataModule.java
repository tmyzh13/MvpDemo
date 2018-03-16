package com.example.issuser.mvpdemo.daggertest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by issuser on 2018/3/16.
 */

@Module
public class DataModule {

    @Provides
    @Singleton
    SingletonTestEntity provodeSingletonTestEntity(){
        return new SingletonTestEntity("测试单例");
    }
}
