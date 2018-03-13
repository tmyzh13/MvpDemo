package com.example.issuser.mvpdemo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by issuser on 2018/3/13.
 */

public abstract class BaseFragment extends Fragment implements BaseView {

    public abstract int getContentViewId();
    protected abstract void initAllMembersView(Bundle savedInstance);

    protected Context mContext;
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView =inflater.inflate(getContentViewId(),container,false);
        this.mContext=getActivity();
        initAllMembersView(savedInstanceState);
        return mRootView;
    }

    @Override
    public void showLoading() {
        checkActivityAttached();
    }

    public void checkActivityAttached(){
        if(getActivity()==null){
            throw new ActivityNotAttachedException();
        }
    }

    public static class ActivityNotAttachedException extends RuntimeException{
        public ActivityNotAttachedException(){
            super("Fragment has disconnected from Activity !");
        }
    }
}
