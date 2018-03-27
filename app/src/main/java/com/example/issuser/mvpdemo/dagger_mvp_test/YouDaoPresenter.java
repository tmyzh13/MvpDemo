package com.example.issuser.mvpdemo.dagger_mvp_test;

import android.util.Log;

import com.example.issuser.mvpdemo.BaseCallBack;
import com.example.issuser.mvpdemo.BasePresenter;
import com.example.issuser.mvpdemo.dagger_mvp_test.api.GetDatas;
import com.example.issuser.mvpdemo.dagger_mvp_test.bean.Movie;
import com.example.issuser.mvpdemo.dagger_mvp_test.bean.Subjects;
import com.example.issuser.mvpdemo.utils.ApiFactory;
import com.trello.rxlifecycle2.components.RxActivity;

import java.util.List;

/**
 * Created by issuser on 2018/3/22.
 */

public class YouDaoPresenter extends DaggerBasePresenter<YouDaoView> {

    private YoudaoDataModel youdaoDataModel;

    @Override
    public void onStart() {
        youdaoDataModel=new YoudaoDataModel();
        youdaoDataModel.getNetApi();
    }

    @Override
    public void setRxActivity(RxActivity activity) {

    }

    @Override
    public void clearRxActivity() {

    }

    public void getNetData(){
        if(!isViewAttached()){
            //已经解绑了
            return;
        }
        getMvpView().showLoading();
        youdaoDataModel.requestGetAPI(new BaseCallBack<String>() {
            @Override
            public void onSuccess(String data) {

            }

            @Override
            public void onFailure(String msg) {

            }

            @Override
            public void onError() {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void getMovieData(int start ,int count){
        if(!isViewAttached()){
            return;
        }
        getMvpView().showLoading();
        youdaoDataModel.getMovies(start, count, getMvpView().getContext(), new BaseCallBack<Movie>() {
            @Override
            public void onSuccess(Movie data) {
                if(isViewAttached()){
                    getMvpView().showLoading();
                }
                List<Subjects> list =data.getSubjects();
                for(int i=0;i<list.size();i++){
                    Log.e("yzh",i+"---"+list.get(i).getTitle());
                }
            }

            @Override
            public void onFailure(String msg) {
                if(isViewAttached()){
                    getMvpView().showToast(msg);
                    getMvpView().hideloading();
                }
            }

            @Override
            public void onError() {
                if(isViewAttached()){
                    getMvpView().showErr();
                    getMvpView().hideloading();
                }
            }

            @Override
            public void onComplete() {
                if(isViewAttached()){
                    getMvpView().hideloading();
                }
            }
        });
    }

//    @Override
//    public void onSuccess(String data) {
//        if(isViewAttached()){
//            getMvpView().showNetData(data);
//        }
//    }
//
//    @Override
//    public void onFailure(String msg) {
//        if(isViewAttached()){
//            getMvpView().showToast(msg);
//            getMvpView().hideloading();
//        }
//    }
//
//    @Override
//    public void onError() {
//        if(isViewAttached()){
//            getMvpView().hideloading();
//            getMvpView().showErr();
//        }
//    }
//
//    @Override
//    public void onComplete() {
//        if(isViewAttached()){
//            getMvpView().hideloading();
//        }
//    }
}
