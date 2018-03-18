package com.example.issuser.mvpdemo.test.Presenter;

import com.example.issuser.mvpdemo.test.data.GetUserData;
import com.example.issuser.mvpdemo.test.data.UserData;
import com.example.issuser.mvpdemo.test.view.IUserView;

import javax.inject.Inject;

/**
 * Created by john on 2018/3/18.
 */

public class MainPresenter {

    public GetUserData mUserData;
    private IUserView mUserView;

    @Inject
    public MainPresenter(GetUserData userData){
        this.mUserData=userData;
    }

    public void getUser(){
        UserData userData = this.mUserData.getUser();
        this.mUserView.setUserName(userData.mUserName);
    }
    public void setUserView(IUserView userView){
        this.mUserView = userView;
    }
}
