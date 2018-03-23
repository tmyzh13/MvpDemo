package com.example.issuser.mvpdemo.dagger_mvp_test;

import android.util.Log;

import com.example.issuser.mvpdemo.BaseCallBack;
import com.example.issuser.mvpdemo.dagger_mvp_test.api.GetDatas;
import com.example.issuser.mvpdemo.utils.ApiFactory;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by issuser on 2018/3/22.
 */

public class YoudaoDataModel implements DaggerBaseModel<String> {

    GetDatas getDatas;

    @Override
    public void getNetApi() {
        getDatas= ApiFactory.getInstance().create(GetDatas.class);
    }

    @Override
    public void requestGetAPI(final BaseCallBack<String> callback) {
        getDatas.getCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //我们对API调用了observeOn(MainThread)之后，线程会跑在主线程上，包括onComplete也是，unsubscribe也在主线程，然后如果这时候调用call.cancel会导致NetworkOnMainThreadException，
                // 所以一定要在retrofit的API调用ExampleAPI.subscribeOn(io).observeOn(MainThread)之后加一句unsubscribeOn(io)。
                .unsubscribeOn(Schedulers.io())
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

    @Override
    public void requestPostAPI( Map params, BaseCallBack<String> callBack) {
    }
}
