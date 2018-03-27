package com.example.issuser.mvpdemo.dagger_mvp_test.testthrea;

import com.example.issuser.mvpdemo.dagger_mvp_test.DaggerBaseView;
import com.example.issuser.mvpdemo.dagger_mvp_test.bean.UserBean;
import com.example.issuser.mvpdemo.test.data.UserData;

/**
 * Created by issuser on 2018/3/27.
 */

public interface TestThreeView extends DaggerBaseView {

    void showUserInfo(UserBean bean);
}
