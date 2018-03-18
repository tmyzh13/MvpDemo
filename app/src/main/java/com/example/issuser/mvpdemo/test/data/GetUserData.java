package com.example.issuser.mvpdemo.test.data;

import javax.inject.Inject;

/**
 * Created by john on 2018/3/18.
 */

public class GetUserData {

    @Inject
    public GetUserData(){

    }

    public UserData getUser(){
        UserData data =new UserData();
        data.mUserName="snake";
        return data;
    }
}
