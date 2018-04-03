package com.example.issuser.mvpdemo.view;

import android.view.View;

/**
 * Created by issuser on 2018/4/3.
 */

public interface OnItemClickListener<T> {

    void onClick(View v, T data);
    boolean onLongClick(View v,T data);
}
