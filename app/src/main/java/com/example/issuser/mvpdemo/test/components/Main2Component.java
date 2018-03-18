package com.example.issuser.mvpdemo.test.components;

import com.example.issuser.mvpdemo.MainActivity;
import com.example.issuser.mvpdemo.test.Modules.ActivityModule;
import com.example.issuser.mvpdemo.test.Modules.MainModule;
import com.example.issuser.mvpdemo.test.scope.PerActivity;
import com.example.issuser.mvpdemo.test.ui.Main2Activity;

import dagger.Component;

/**
 * Created by john on 2018/3/18.
 */
@PerActivity
@Component(dependencies = AppComponent.class,modules = {MainModule.class, ActivityModule.class})
public interface Main2Component extends ActivityComponent{

    //对MainActivity进行依赖注入
    void inject(Main2Activity mainActivity);
    MainFragmentComponent mainFragmentComponent();
}
