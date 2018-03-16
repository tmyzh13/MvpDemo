package com.example.issuser.mvpdemo.daggertest;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * 下层Module类
 * Created by issuser on 2018/3/16.
 */

@Module
public class ActivityMoudule {

    @Provides
    Person2 providePerson(Context context){
        return new Person2(context);
    }

//    @Named("context")
    @PersonForContext
    @Provides
    Person3 providePersonContext(Context context){
        return new Person3(context);
    }

//    @Named("name")
    @PersonForName
    @Provides
    Person3 providePersonName(){
        return new Person3("1234");
    }

}
