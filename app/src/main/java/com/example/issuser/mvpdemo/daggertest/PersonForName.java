package com.example.issuser.mvpdemo.daggertest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import dagger.Provides;

/**
 * Created by issuser on 2018/3/16.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonForName {
    //name 对象的注解
}
