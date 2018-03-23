package com.example.issuser.mvpdemo.utils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by issuser on 2018/3/22.
 */

public class ApiFactory {

    public static ApiFactory instance;

    private Retrofit retrofit;

    private ApiFactory(){
        retrofit=new Retrofit.Builder()
                .baseUrl(Urls.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }

    public static ApiFactory getInstance(){
        if(instance==null){
            instance=new ApiFactory();
        }
        return instance;
    }

    public <T>T create(Class<T> clz){
        return retrofit.create(clz);
    }



}
