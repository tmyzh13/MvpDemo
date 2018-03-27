package com.example.issuser.mvpdemo.dagger_mvp_test.testthrea;

import android.os.Bundle;
import android.widget.TextView;

import com.example.issuser.mvpdemo.BaseActivity;
import com.example.issuser.mvpdemo.R;
import com.example.issuser.mvpdemo.dagger_mvp_test.DaggerBaseActivity;
import com.example.issuser.mvpdemo.dagger_mvp_test.DaggerBasePresenter;
import com.example.issuser.mvpdemo.dagger_mvp_test.bean.UserBean;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by issuser on 2018/3/27.
 */

public class TestActivityThree extends DaggerBaseActivity<TestThreeView,TestThreePresenter> implements TestThreeView{

    @Bind(R.id.tv_login)
    TextView tv_login;



    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_test_three;
    }

    @Override
    protected TestThreePresenter creatPresenter() {
        return new TestThreePresenter();
    }

    @OnClick(R.id.tv_login)
    public void goLogin(){
        presenter.login("112320","11111111111111");
    }

    @Override
    public void showUserInfo(UserBean bean) {

    }
}
