package com.example.issuser.mvpdemo.dagger_mvp_test.api;

import com.example.issuser.mvpdemo.dagger_mvp_test.bean.Movie;
import com.example.issuser.mvpdemo.utils.Urls;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by issuser on 2018/3/23.
 */

public interface GetDoubanMovies {

    @GET(Urls.getMovies)
    Observable<Movie> getMovies(@Query("start") int start, @Query("count") int count);
}
