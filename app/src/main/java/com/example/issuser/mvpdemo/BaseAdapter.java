package com.example.issuser.mvpdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.issuser.mvpdemo.view.OnItemClickListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by issuser on 2018/4/3.
 */

public class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {


    public List<T> dataList;
    public OnItemClickListener listener;
    public BaseDelegate delegate;

    public BaseAdapter(List<T> dataList,BaseDelegate delegate){
        this(dataList, delegate, null);
    }
    public BaseAdapter(List<T> dataList, BaseDelegate delegate, OnItemClickListener listener) {
        this.dataList=new ArrayList<>();
        this.delegate = delegate;
        this.listener = listener;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return delegate.onCreateViewHolder(parent,viewType);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {
        holder.onBindViewHolder(dataList.get(position));
        if(listener!=null&&holder.enable()){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v, dataList.get(position));
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return listener.onLongClick(v, dataList.get(position));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return delegate.getItemViewType(position);
    }
}
