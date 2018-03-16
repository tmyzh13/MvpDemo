package com.example.issuser.mvpdemo.daggertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.issuser.mvpdemo.BaseActivity;
import com.example.issuser.mvpdemo.R;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by issuser on 2018/3/16.
 */

public class DaggerTest3Activity extends BaseActivity {


//    @Named("context")
    @PersonForContext
    @Inject
    Person3 person;

//    @Named("name")
    @PersonForName
    @Inject
    Person3 person2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        AppComponent appCom =DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        DaggerActivityComponent.builder()
                .appComponent(appCom)
                .activityMoudule(new ActivityMoudule())
                .build().inject(this);
//        03-16 14:27:36.592 16725-16725/com.example.issuser.mvpdemo E/yzh: Person3 context
//        03-16 14:27:36.592 16725-16725/com.example.issuser.mvpdemo E/yzh: Person3 name
        //自定义注解
//        03-16 14:53:38.522 18717-18717/com.example.issuser.mvpdemo E/yzh: Person3 context
//        03-16 14:53:38.522 18717-18717/com.example.issuser.mvpdemo E/yzh: Person3 name
    }
}
