package com.example.issuser.mvpdemo.dagger_mvp_test;

import android.util.Log;

/**
 * Created by issuser on 2018/2/7.
 */

public class Translation {

    private int status;
    private content content;
    private static class content{
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }
    public String show(){
//        Log.e("yzh",content.out);
        return content.out;
    }
}
