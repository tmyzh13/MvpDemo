package com.example.issuser.mvpdemo.view.testadapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.issuser.mvpdemo.BaseViewHolder;

/**
 * Created by issuser on 2018/4/3.
 */

public class SelfInfoViewHolder extends BaseViewHolder<ItemData> {

    private ImageView headView;
    private TextView nameGender;
    private TextView birthday;

    public SelfInfoViewHolder(ViewGroup parent, View itemView) {
        super(parent, itemView);
    }

    @Override
    public void findViews() {

    }

    @Override
    public void onBindViewHolder(ItemData data) {

    }
}
