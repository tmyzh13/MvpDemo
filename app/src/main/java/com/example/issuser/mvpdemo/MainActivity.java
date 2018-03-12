package com.example.issuser.mvpdemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MvpView {

    private TextView tv_s;
    private TextView tv_f;
    private TextView tv_e;

    ProgressDialog progressDialog;
    MvpPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_s=(TextView)findViewById(R.id.tv_s);
        tv_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getData(MvpModel.Action.NORMAL);
            }
        });
        tv_f=(TextView)findViewById(R.id.tv_f);
        tv_e=(TextView)findViewById(R.id.tv_e);

        // 初始化进度条
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在加载数据");

        //初始化Presenter
        presenter = new MvpPresenter(this);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showData(String data) {

    }

    @Override
    public void showFailureMessage(String msg) {

    }

    @Override
    public void showErrorMessage() {

    }
}
