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

public class YoudaoDataModel extends DaggerBaseModel<String> {

    GetDatas getDatas;

    @Override
    protected void getNetApi() {
        super.getNetApi();
        getDatas= ApiFactory.getInstance().create(GetDatas.class);
    }

    @Override
    protected void requestGetAPI(final BaseCallBack<String> callback) {
        getDatas.getCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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
    protected void requestPostAPI( Map params, BaseCallBack<String> callBack) {
    }
}
