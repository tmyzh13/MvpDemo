package com.example.issuser.mvpdemo;

/**
 * Created by issuser on 2018/3/13.
 */

public class MvpPresenter3 extends BasePresenter<MvpView2>{

        public void getDataNew(MvpModel.Action action){
            if(!isViewAttached()){
                return;
            }

            getMvpView().showLoading();

            DataModel.request(Token.API_USER_DATA)
                    .params(action)
                    .execute(new BaseCallBack<String>() {
                        @Override
                        public void onSuccess(String data) {
                            if(isViewAttached()){
                                getMvpView().showData(data);
                            }

                        }

                        @Override
                        public void onFailure(String msg) {
                            if(isViewAttached()){
                                getMvpView().showToast(msg);
                            }
                        }

                        @Override
                        public void onError() {
                            if(isViewAttached()){
                                getMvpView().showErr();
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

        public void getData(MvpModel.Action action){
            if(!isViewAttached()){
                //如果没有view引用就不加载数据
                return;
            }
            getMvpView().showLoading();
            MvpModel.getNetData2(action, new BaseCallBack<String>() {
                @Override
                public void onSuccess(String data) {
                    if(isViewAttached()){
                        getMvpView().showData(data);
                    }
                }

                @Override
                public void onFailure(String msg) {
                    if(isViewAttached()){
                        getMvpView().showToast(msg);
                    }
                }

                @Override
                public void onError() {
                    if(isViewAttached()){
                        getMvpView().showErr();
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
}
