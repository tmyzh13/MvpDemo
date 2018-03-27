package com.example.issuser.mvpdemo.dagger_mvp_test.api;

import com.example.issuser.mvpdemo.dagger_mvp_test.bean.BaseData;
import com.example.issuser.mvpdemo.utils.Urls;


import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by issuser on 2018/3/27.
 */

public interface TestApi {
    @GET(Urls.testUrl)
    Observable<BaseData<String>> login(@QueryMap Map<String,Object> request);
}
