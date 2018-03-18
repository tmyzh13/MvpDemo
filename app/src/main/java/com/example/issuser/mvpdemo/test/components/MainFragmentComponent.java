package com.example.issuser.mvpdemo.test.components;

import com.example.issuser.mvpdemo.test.scope.PerActivity;
import com.example.issuser.mvpdemo.test.ui.MainFragement;

import dagger.Subcomponent;

/**
 * Created by john on 2018/3/18.
 */
@PerActivity
@Subcomponent
public interface MainFragmentComponent {
    void inject(MainFragement mainFragment);
}
