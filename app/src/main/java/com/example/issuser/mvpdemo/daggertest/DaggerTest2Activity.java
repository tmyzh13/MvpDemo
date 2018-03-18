package com.example.issuser.mvpdemo.daggertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.issuser.mvpdemo.BaseActivity;
import com.example.issuser.mvpdemo.R;

import javax.inject.Inject;

/**
 * 测试单例注解
 * Created by issuser on 2018/3/16.
 */

public class DaggerTest2Activity extends BaseActivity {

    @Inject
    Person person;
    @Inject
    Person person2;




    @Override
    protected int getLayoutId() {
        return R.layout.activity_dagger;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        //构造桥梁对象
        MainComponent component =DaggerMainComponent.builder().mainModule(new MainModule(this)).build();
        //注入
        component.inject(this);
        Log.e("yzh","Person "+person.toString()+"---"+"Person2 "+person2.toString());
//        03-16 10:55:54.257 23928-23928/com.example.issuser.mvpdemo E/yzh: person create!!!
//                03-16 10:55:54.257 23928-23928/com.example.issuser.mvpdemo E/yzh: person create!!!
//                03-16 10:55:54.257 23928-23928/com.example.issuser.mvpdemo E/yzh: Person com.example.issuser.mvpdemo.daggertest.Person@7648445---Person2 com.example.issuser.mvpdemo.daggertest.Person@877879a

//        03-16 11:03:17.639 26433-26433/com.example.issuser.mvpdemo E/yzh: person create!!!
//                03-16 11:03:17.639 26433-26433/com.example.issuser.mvpdemo E/yzh: Person com.example.issuser.mvpdemo.daggertest.Person@7648445---Person2 com.example.issuser.mvpdemo.daggertest.Person@7648445
    }
}
