package com.example.issuser.mvpdemo.view.testadapter;

import android.view.View;
import android.view.ViewGroup;

import com.example.issuser.mvpdemo.BaseViewHolder;


/**
 * Created by hzsunyj on 16/12/30.
 */
public class SeparateViewHolder extends BaseViewHolder<ItemData> {

    /**
     * @param parent
     * @param view
     */
    public SeparateViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {

    }

    @Override
    public void onBindViewHolder(ItemData data) {

    }

    @Override
    public boolean enable() {
        return false;
    }
}
