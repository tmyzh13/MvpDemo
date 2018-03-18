package com.example.issuser.mvpdemo.test.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.issuser.mvpdemo.test.App;
import com.example.issuser.mvpdemo.test.components.AppComponent;

/**
 * Created by john on 2018/3/18.
 */

public class BaseActivity extends Activity {

    public AppComponent getAppComponent(){
        return ((App)getApplication()).getAppComponent();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
