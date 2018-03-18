package com.example.issuser.mvpdemo.test.components;

import android.app.Activity;

import com.example.issuser.mvpdemo.test.Modules.ActivityModule;
import com.example.issuser.mvpdemo.test.scope.PerActivity;

import dagger.Component;

/**
 * Created by john on 2018/3/18.
 */

@PerActivity
@Component(modules = {ActivityModule.class})
public interface ActivityComponent {
    Activity getActivity();
}
