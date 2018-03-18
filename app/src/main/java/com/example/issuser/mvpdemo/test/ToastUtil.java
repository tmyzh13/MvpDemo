package com.example.issuser.mvpdemo.test;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by john on 2018/3/18.
 */

public class ToastUtil {

    private Context mContext;

    public ToastUtil(Context context){
        this.mContext=context;
    }

    public void showToast(String message){
        Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
    }

}
