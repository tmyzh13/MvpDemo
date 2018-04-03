package com.example.issuser.mvpdemo.view.testadapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.issuser.mvpdemo.BaseViewHolder;
import com.example.issuser.mvpdemo.R;


/**
 * Created by hzsunyj on 2018/1/2.
 */

public class TextViewHolder extends BaseViewHolder<String> {


    private TextView textView;

    /**
     * @param parent current no use, may be future use
     * @param view
     */
    public TextViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {
        textView = (TextView) itemView.findViewById(R.id.content);
    }

    @Override
    public void onBindViewHolder(String data) {
        textView.setText(data);
    }
}
