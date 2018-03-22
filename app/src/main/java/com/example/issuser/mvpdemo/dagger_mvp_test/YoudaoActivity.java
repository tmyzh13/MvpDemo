package com.example.issuser.mvpdemo.dagger_mvp_test;

import android.os.Bundle;
import android.widget.TextView;

import com.example.issuser.mvpdemo.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by issuser on 2018/3/22.
 */

public class YoudaoActivity extends DaggerBaseActivity<YouDaoView,YouDaoPresenter> implements YouDaoView {

   @Bind(R.id.tv_get_data)
   TextView tv_get_data;
   @Bind(R.id.tv_data)
   TextView tv_data;

    @Override
    public void showNetData(String msg) {
        tv_data.setText(msg);
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_youdao;
    }

    @Override
    protected YouDaoPresenter creatPresenter() {
        return new YouDaoPresenter();
    }

    @OnClick(R.id.tv_get_data)
    public void getNetData(){
        presenter.getNetData();
    }
}
