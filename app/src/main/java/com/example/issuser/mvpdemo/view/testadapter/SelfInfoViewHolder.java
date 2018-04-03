package com.example.issuser.mvpdemo.view.testadapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.issuser.mvpdemo.BaseViewHolder;
import com.example.issuser.mvpdemo.R;

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
        headView = (ImageView) itemView.findViewById(R.id.self_info_head_view);
        nameGender = (TextView) itemView.findViewById(R.id.self_name_gender);
        birthday = (TextView) itemView.findViewById(R.id.birthday);
    }

    @Override
    public void onBindViewHolder(ItemData data) {

    }

    @Override
    public boolean enable() {
        return false;
    }
}
