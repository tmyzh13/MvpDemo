package com.example.issuser.mvpdemo.daggertest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by issuser on 2018/3/16.
 */

@Qualifier//关键词
@Retention(RetentionPolicy.RUNTIME) //运行时仍可用
public @interface PersonForContext {
}
