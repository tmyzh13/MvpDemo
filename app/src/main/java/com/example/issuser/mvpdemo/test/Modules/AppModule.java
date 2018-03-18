package com.example.issuser.mvpdemo.test.Modules;

import android.content.Context;

import com.example.issuser.mvpdemo.test.ToastUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by john on 2018/3/18.
 */

@Module
public class AppModule {
    Context context;

    public AppModule(Context context){
        this.context=context;
    }
    @Provides
    @Singleton
    public Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    public ToastUtil provideToastUtil(){
        return new ToastUtil(context);
    }
}
