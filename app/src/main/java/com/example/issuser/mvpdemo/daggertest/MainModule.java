package com.example.issuser.mvpdemo.daggertest;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 对象实例化 类似于容器
 * Created by issuser on 2018/3/15.
 */

@Module //提供依赖对象的实例
public class MainModule {

    private Context mContext;

    public MainModule(Context context){
        mContext=context;
    }

    @Provides
    Context providesContext(){
        //提供上下文对象
        return mContext;
    }

    @Provides//关键字，标明该方法提供依赖对象
    @Singleton
    Person2 providesPerson2(){
        return new Person2(mContext);
    }

    @Provides //关键字，标明该方法提供依赖的对象
    @Singleton
    Person providePerson(){
        //提供Person对象
        return new Person();
    }


}
