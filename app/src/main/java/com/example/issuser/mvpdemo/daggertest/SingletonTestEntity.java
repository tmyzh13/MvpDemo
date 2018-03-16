package com.example.issuser.mvpdemo.daggertest;

import javax.inject.Inject;

/**
 * Created by issuser on 2018/3/16.
 */

public class SingletonTestEntity {

    private String desc;

    @Inject
    public SingletonTestEntity(String desc){
        this.desc=desc;
    }

    public String getDesc(){
        return desc;
    }
}
