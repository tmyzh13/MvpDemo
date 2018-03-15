package com.example.issuser.mvpdemo.daggertest;

import dagger.Module;
import dagger.Provides;

/**
 * 对象实例化 类似于容器
 * Created by issuser on 2018/3/15.
 */

@Module //提供依赖对象的实例
public class MainModule {

    @Provides
    Person providePerson(){
        return new Person();
    }

}
