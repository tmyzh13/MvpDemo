package com.example.issuser.mvpdemo.dagger_mvp_test;

import android.content.Context;
import android.util.Log;

import com.example.issuser.mvpdemo.BaseCallBack;
import com.example.issuser.mvpdemo.dagger_mvp_test.api.GetDatas;
import com.example.issuser.mvpdemo.dagger_mvp_test.api.GetDoubanMovies;
import com.example.issuser.mvpdemo.dagger_mvp_test.api.TestApi;
import com.example.issuser.mvpdemo.dagger_mvp_test.bean.Movie;
import com.example.issuser.mvpdemo.dagger_mvp_test.rxtests.MyObserver;
import com.example.issuser.mvpdemo.dagger_mvp_test.rxtests.ObserverOnNextListener;
import com.example.issuser.mvpdemo.utils.ApiFactory;
import com.example.issuser.mvpdemo.utils.ApiMethod;
import com.trello.rxlifecycle2.components.RxActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by issuser on 2018/3/22.
 */

public class YoudaoDataModel implements DaggerBaseModel<String> {

    GetDatas getDatas;
    GetDoubanMovies getMovies;
    TestApi testApi;

    @Override
    public void getNetApi() {
        getDatas= ApiFactory.getInstance().create(GetDatas.class);
        getMovies=ApiFactory.getInstance().create(GetDoubanMovies.class);
        testApi=ApiFactory.getInstance().create(TestApi.class);
    }



    @Override
    public void requestGetAPI(final BaseCallBack<String> callback) {
        getDatas.getCall()
                .map(new Function<Translation, Translation>() {
                    @Override
                    public Translation apply(Translation translation) throws Exception {
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //我们对API调用了observeOn(MainThread)之后，线程会跑在主线程上，包括onComplete也是，unsubscribe也在主线程，然后如果这时候调用call.cancel会导致NetworkOnMainThreadException，
                // 所以一定要在retrofit的API调用ExampleAPI.subscribeOn(io).observeOn(MainThread)之后加一句unsubscribeOn(io)。
                .unsubscribeOn(Schedulers.io())
//                .subscribe(new Consumer<Translation>() {
//                    @Override
//                    public void accept(Translation translation) throws Exception {
//
//                    }
//                });
                .subscribe(new Observer<Translation>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("yzh","onSubscribe");
            }

            @Override
            public void onNext(Translation translation) {
                Log.e("yzh","oNext--"+translation.show());
                callback.onSuccess(translation.show());
            }

            @Override
            public void onError(Throwable e) {
                Log.e("yzh","onError--"+e.getMessage());
                callback.onFailure(e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e("yzh","onComplete--");
                callback.onComplete();
            }
        });
    }

    public void getMovies(int start, int count, Context context, final BaseCallBack<Movie> callBack){
        ApiMethod.ApiSubscribe(getMovies.getMovies(start,count),new MyObserver(context, new ObserverOnNextListener<Movie>() {
            @Override
            public void onNext(Movie data) {
                callBack.onSuccess(data);
            }

            @Override
            public void Error(int code) {
                callBack.onError();
            }

            @Override
            public void hideLoading() {
                callBack.onComplete();
            }
        }));
    }
    @Override
    public void requestPostAPI( Map params, BaseCallBack<String> callBack) {

    }




}
