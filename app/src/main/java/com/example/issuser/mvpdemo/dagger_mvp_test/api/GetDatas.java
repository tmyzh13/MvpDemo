package com.example.issuser.mvpdemo.dagger_mvp_test.api;

import com.example.issuser.mvpdemo.dagger_mvp_test.Translation;
import com.example.issuser.mvpdemo.utils.Urls;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by issuser on 2018/3/22.
 */

public interface GetDatas {

    @GET(Urls.test)
    Observable<Translation> getCall();

    @GET(Urls.test1)
    Observable<Translation> getCall1();
}
