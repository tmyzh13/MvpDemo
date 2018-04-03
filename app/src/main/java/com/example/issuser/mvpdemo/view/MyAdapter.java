package com.example.issuser.mvpdemo.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.issuser.mvpdemo.R;

import java.util.ArrayList;

/**
 * Created by issuser on 2018/4/2.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener {

    public ArrayList<String> datas=null;

    public MyAdapter(ArrayList datas){
        this.datas=datas;
    }

    //创建viewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview,parent,false);
        ViewHolder vh=new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }

    //控件设置数据
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(datas.get(position));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        Log.e("yzh","data=="+datas.size());
        return datas.size();
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(v,(Integer) v.getTag());
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ViewHolder(View view){
            super(view);
            mTextView = (TextView) view.findViewById(R.id.text);
        }
    }

    public interface RecyclerItemClickListener{
        void onItemClick(View view,int position);
    }

    private RecyclerItemClickListener listener;
    public void setRecyclerItemClickListener(RecyclerItemClickListener listener){
        this.listener=listener;
    }

    public void addItem(String content, int position) {
        datas.add(position, content);
        //注意build。gradle里面加入的代码块 统一v4版本
        notifyItemInserted(position); //Attention!
//        notifyDataSetChanged();
    }
}
