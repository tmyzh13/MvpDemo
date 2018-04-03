package com.example.issuser.mvpdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by issuser on 2018/4/3.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseViewHolder(ViewGroup parent,View itemView) {
        super(itemView);
        findViews();
    }

    public abstract void findViews();

    public abstract void onBindViewHolder(T data);

    /**
     * holder click enable
     *
     * @return
     */
    public boolean enable() {
        return true;
    }

}
