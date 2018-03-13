package com.example.issuser.mvpdemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MvpView {

    private TextView tv_s;
    private TextView tv_f;
    private TextView tv_e;

    ProgressDialog progressDialog;
    MvpPresenter presenter;
    MvpPresenter2 presenter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("yzh","1111111");

        tv_s=(TextView)findViewById(R.id.tv_s);
        tv_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getData(MvpModel.Action.NORMAL);
            }
        });
        tv_f=(TextView)findViewById(R.id.tv_f);
        tv_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getData(MvpModel.Action.FAILUER);
            }
        });
        tv_e=(TextView)findViewById(R.id.tv_e);
        tv_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getData(MvpModel.Action.ERROR);
            }
        });

        // 初始化进度条
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在加载数据");

        //初始化Presenter
        presenter = new MvpPresenter(this);

        //presenter2绑定view
        presenter2=new MvpPresenter2();
        presenter2.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter2.detachView();
    }

    @Override
    public void showLoading() {
        if(!progressDialog.isShowing()){
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

    @Override
    public void showData(String data) {
        if(!TextUtils.isEmpty(data)){
            Toast.makeText(MainActivity.this,data,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showFailureMessage(String msg) {
        if(!TextUtils.isEmpty(msg)){
            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(MainActivity.this,"网络请求出错",Toast.LENGTH_SHORT).show();
    }
}
