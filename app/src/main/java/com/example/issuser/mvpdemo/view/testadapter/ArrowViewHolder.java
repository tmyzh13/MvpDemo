package com.example.issuser.mvpdemo.view.testadapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.issuser.mvpdemo.BaseViewHolder;
import com.example.issuser.mvpdemo.R;

/**
 * Created by john on 2018/4/3.
 */

public class ArrowViewHolder extends BaseViewHolder<ItemData> {

    private TextView name;

    public ArrowViewHolder(ViewGroup parent, View itemView) {
        super(parent, itemView);
    }

    @Override
    public void findViews() {
        name = (TextView) itemView.findViewById(R.id.display_setting_name);
    }

    @Override
    public void onBindViewHolder(ItemData data) {
        name.setText(data.itemDesc);
    }
}
