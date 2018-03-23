package com.example.issuser.mvpdemo.dagger_mvp_test;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.issuser.mvpdemo.BaseActivity;
import com.example.issuser.mvpdemo.BasePresenter;
import com.example.issuser.mvpdemo.BaseView;
import com.example.issuser.mvpdemo.utils.AppManager;

import butterknife.ButterKnife;

/**
 * Created by issuser on 2018/3/22.
 */

public abstract class DaggerBaseActivity<V extends DaggerBaseView,T extends DaggerBasePresenter> extends Activity implements DaggerBaseView {

    protected T presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        //将当前activity加入自定义的app管理中
        AppManager.getInstance().addActivity(this);
        presenter=creatPresenter();
        if(presenter!=null){
            //绑定当前页面的view,用于presnter获取数据之后控制activity的变化
            presenter.attachView((V)this);
        }
        ButterKnife.bind(this);
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        init(savedInstanceState);
        if(presenter!=null){
            presenter.onStart();
        }
    }

    /**
     * 做一些初始化操作
     * @param savedInstanceState
     */
    protected abstract void init(Bundle savedInstanceState);

    /**
     * 指定需要加载的布局文件
     * @return
     */
    protected abstract int getLayoutRes();

    /**
     * 创建presenter对象
     */
    protected abstract T creatPresenter();

    /**
     * 使用presenter对象
     * @return
     */
    public T getPresnter(){
       return presenter;
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideloading() {
        progressDialog.hide();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErr() {
        Toast.makeText(getContext(),"出错",Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return DaggerBaseActivity.this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detachView();
        }
        presenter=null;
        AppManager.getInstance().finishActivity(this);
    }
}
