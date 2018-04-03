package com.example.issuser.mvpdemo.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.issuser.mvpdemo.R;

/**
 * Created by issuser on 2018/4/3.
 */

public class PaddingDecoration extends RecyclerView.ItemDecoration {

    private int padding;

    public PaddingDecoration(Context context){
        padding=context.getResources().getDimensionPixelSize(R.dimen.padding);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //outRect就是你那个item条目的矩形
        outRect.left = padding;  //相当于 设置 left padding
        outRect.top = padding;   //相当于 设置 top padding
        outRect.right = padding; //相当于 设置 right padding
        outRect.bottom = padding;  //相当于 设置 bottom padding
    }
}
