package com.example.issuser.mvpdemo.daggertest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.issuser.mvpdemo.R;
import com.example.issuser.mvpdemo.daggertest.DaggerMainComponent;

import javax.inject.Inject;

/**
 * Created by issuser on 2018/3/15.
 */

public class DaggerTestActivity extends Activity{

    @Inject //标明需要注入的对象
    Person person;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        //构建桥梁
        MainComponent component = DaggerMainComponent.builder().mainModule(new MainModule()).build();
        //注入
        //注入之后会查找当前类中（@Inject）对象
        //再根据成员变量类型从module中查找哪个有@Provides注解的方法返回值为当前类型。
        component.inject(this);
        Log.e("yzh","person: "+person.toString());
    }
}
