package com.example.issuser.mvpdemo.daggertest;

import dagger.Module;
import dagger.Provides;

/**
 * 对象实例化 类似于容器
 * Created by issuser on 2018/3/15.
 */

@Module //提供依赖对象的实例
public class MainModule {

    @Provides //关键字，标明该方法提供依赖的对象
    Person providePerson(){
        //提供Person对象
        return new Person();
    }

}
