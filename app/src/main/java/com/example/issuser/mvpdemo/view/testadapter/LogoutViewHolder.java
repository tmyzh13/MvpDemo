package com.example.issuser.mvpdemo.view.testadapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.issuser.mvpdemo.BaseViewHolder;
import com.example.issuser.mvpdemo.R;

/**
 * Created by john on 2018/4/3.
 */

public class LogoutViewHolder extends BaseViewHolder<ItemData>{
    private TextView logout;

    public LogoutViewHolder(ViewGroup parent, View itemView) {
        super(parent, itemView);
    }

    @Override
    public void findViews() {
        logout = (TextView) itemView.findViewById(R.id.logout_btn);
    }

    @Override
    public void onBindViewHolder(ItemData data) {

    }
}
