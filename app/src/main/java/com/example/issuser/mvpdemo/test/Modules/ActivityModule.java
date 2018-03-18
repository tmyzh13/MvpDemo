package com.example.issuser.mvpdemo.test.Modules;

import android.app.Activity;

import com.example.issuser.mvpdemo.test.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by john on 2018/3/18.
 */

@Module
public class ActivityModule {

    private Activity activity;
    public ActivityModule(Activity activity){
        this.activity=activity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity(){
        return activity;
    }
}
