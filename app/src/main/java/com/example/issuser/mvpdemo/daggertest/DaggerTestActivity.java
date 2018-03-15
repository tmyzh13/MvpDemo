package com.example.issuser.mvpdemo.daggertest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

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

        MainComponent component = DaggerMainComponent.builder().mainModule(new MainModule()).build();
        //注入
        component.inject(this);
    }
}
