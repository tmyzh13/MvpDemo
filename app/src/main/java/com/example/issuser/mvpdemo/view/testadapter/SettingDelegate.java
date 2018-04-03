package com.example.issuser.mvpdemo.view.testadapter;

import android.content.ClipData;
import android.view.ViewGroup;

import com.example.issuser.mvpdemo.BaseDelegate;
import com.example.issuser.mvpdemo.BaseViewHolder;

/**
 * Created by issuser on 2018/4/3.
 */

public class SettingDelegate extends BaseDelegate<ItemData> {

    public static final int SEPARATE_TYPE =0;
    public static final int SELF_INFO=1;
    public static final int ARROW_TYPE=2;
    public static final int CHECK_TYPE=3;
    public static final int TOGGLE_TYPE=4;
    public static final int LOGOUT_TYPE=5;

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemViewType(ItemData data) {
        return 0;
    }

    @Override
    public int getLayoutId(int viewType) {
        return 0;
    }
}
