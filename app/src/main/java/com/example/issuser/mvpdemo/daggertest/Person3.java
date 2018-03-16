package com.example.issuser.mvpdemo.daggertest;

import android.content.Context;
import android.util.Log;

/**
 * Created by issuser on 2018/3/16.
 */

public class Person3 {

    private Context mContext;

    public Person3(Context context){
        mContext=context;
        Log.e("yzh","Person3 context");
    }

    public Person3(String name){
        Log.e("yzh","Person3 name");
    }
}
