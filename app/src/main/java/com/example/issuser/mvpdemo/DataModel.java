package com.example.issuser.mvpdemo;

/**
 * Created by issuser on 2018/3/13.
 */

public class DataModel {

    public static BaseModel request(String token){
        BaseModel model =null;
        try {
            model=(BaseModel)Class.forName(token).newInstance();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return model;
    }
}
