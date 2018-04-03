package com.example.issuser.mvpdemo.test;

import android.app.Application;

import com.example.issuser.mvpdemo.test.Modules.AppModule;
import com.example.issuser.mvpdemo.test.components.AppComponent;
import com.example.issuser.mvpdemo.test.components.DaggerAppComponent;

/**
 * Created by john on 2018/3/18.
 */

public class App extends Application{

    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent= DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }


    public AppComponent getAppComponent(){
        return mAppComponent;
    }
}
