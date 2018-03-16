package com.example.issuser.mvpdemo.daggertest;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by issuser on 2018/3/16.
 */
@Module
public class AppModule {

    private Context mContext;

    public AppModule(Context context){
        mContext=context;
    }

    @Provides
    Context providesContext(){
        return mContext;
    }
}
