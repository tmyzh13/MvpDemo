package com.example.issuser.mvpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by issuser on 2018/3/13.
 * 平民版mvp
 */

public class SecondActivity  extends BaseActivity implements MvpView2{

    private  MvpPresenter3 presenter;
    private TextView tv_s;
    private TextView tv_f;
    private TextView tv_e;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
        presenter=new MvpPresenter3();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showData(String data) {
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
    }
}
