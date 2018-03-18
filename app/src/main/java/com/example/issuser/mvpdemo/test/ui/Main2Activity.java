package com.example.issuser.mvpdemo.test.ui;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.issuser.mvpdemo.R;
import com.example.issuser.mvpdemo.daggertest.MainComponent;
import com.example.issuser.mvpdemo.test.Modules.ActivityModule;
import com.example.issuser.mvpdemo.test.Modules.MainModule;
import com.example.issuser.mvpdemo.test.components.DaggerMain2Component;
import com.example.issuser.mvpdemo.test.components.Main2Component;

/**
 * Created by john on 2018/3/18.
 */

public class Main2Activity extends BaseActivity implements MainFragement.OnFragmentInteractionListener{

    private Main2Component mMain2Component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mMain2Component = DaggerMain2Component.builder()
                .appComponent(getAppComponent())
                .mainModule(new MainModule())
                .activityModule(new ActivityModule(this)).build();
        mMain2Component.inject(this);
    }

    public Main2Component getMainComponent(){
        return mMain2Component;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
