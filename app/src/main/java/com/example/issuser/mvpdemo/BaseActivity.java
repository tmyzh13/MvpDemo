package com.example.issuser.mvpdemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by issuser on 2018/3/13.
 */

public abstract class BaseActivity extends Activity implements BaseView {

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog=new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
    }

    @Override
    public void showLoading() {
        if(!mProgressDialog.isShowing()){
            mProgressDialog.show();
        }
    }

    @Override
    public void hideloading() {
        if(mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErr() {
        showToast("网络异常");
    }

    @Override
    public Context getContext() {
        return BaseActivity.this;
    }
}
