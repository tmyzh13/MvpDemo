package com.example.issuser.mvpdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by issuser on 2018/4/3.
 */

public abstract class BaseDelegate<T> {

    public abstract BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType);
    public abstract int getItemViewType(T data);
    public abstract int getLayoutId(int viewType);
    public View getItemView(ViewGroup parent, int viewType) {
        return LayoutInflater.from(parent.getContext()).inflate(getLayoutId(viewType), parent, false);
    }
}
