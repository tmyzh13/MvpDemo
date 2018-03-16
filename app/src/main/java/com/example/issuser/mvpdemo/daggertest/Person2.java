package com.example.issuser.mvpdemo.daggertest;

import android.content.Context;
import android.util.Log;

/**
 * Created by issuser on 2018/3/16.
 */

public class Person2 {

    private Context context;
    public Person2(Context context){
        this.context=context;
        Log.e("yzh","person2 create");
    }
}
