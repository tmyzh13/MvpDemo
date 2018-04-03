package com.example.issuser.mvpdemo.view.testadapter;

import android.content.ClipData;
import android.view.ViewGroup;

import com.example.issuser.mvpdemo.BaseDelegate;
import com.example.issuser.mvpdemo.BaseViewHolder;
import com.example.issuser.mvpdemo.R;

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
        switch (viewType) {
            case SEPARATE_TYPE:
                return new SeparateViewHolder(parent, getItemView(parent, viewType));
            case SELF_INFO:
                return new SelfInfoViewHolder(parent, getItemView(parent, viewType));
            case ARROW_TYPE:
                return new ArrowViewHolder(parent, getItemView(parent, viewType));
            case CHECK_TYPE:
                return new CheckViewHolder(parent, getItemView(parent, viewType));
            case TOGGLE_TYPE:
                return new ToggleViewHolder(parent, getItemView(parent, viewType));
            case LOGOUT_TYPE:
                return new LogoutViewHolder(parent, getItemView(parent, viewType));
        }
        return null;
    }

    @Override
    public int getItemViewType(ItemData data) {
        return data.holderType;
    }

    @Override
    public int getLayoutId(int viewType) {
        switch (viewType) {
            case SEPARATE_TYPE:
                return R.layout.view_holder_setting_separate;
            case SELF_INFO:
                return R.layout.view_holder_setting_user_info;
            case ARROW_TYPE:
                return R.layout.view_holder_setting_arrow;
            case CHECK_TYPE:
                return R.layout.view_holder_setting_check;
            case TOGGLE_TYPE:
                return R.layout.view_holder_setting_toggle;
            case LOGOUT_TYPE:
                return R.layout.view_holder_setting_logout;
        }
        return 0;
    }
}
