package com.example.issuser.mvpdemo.view;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.issuser.mvpdemo.R;
import com.example.issuser.mvpdemo.dagger_mvp_test.DaggerBaseActivity;
import com.example.issuser.mvpdemo.dagger_mvp_test.DaggerBasePresenter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by issuser on 2018/4/2.
 */

public class RecycleViewTestActivity extends DaggerBaseActivity {


    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private ArrayList<String> datas;
    private MyAdapter adapter;
    @Override
    protected void init(Bundle savedInstanceState) {
        datas=new ArrayList<>();
        datas.add("yzh");
        datas.add("yhz");
        datas.add("hzy");

        linearLayoutManager =new LinearLayoutManager(this);
        gridLayoutManager =new GridLayoutManager(this,2);
        staggeredGridLayoutManager =new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        //recycleview 的一个性能优化配置，当item不影响listview宽高变化时
        //直接用adapter的增删改查来刷新，notifydataChange不受这个设置影响
        recyclerView.setHasFixedSize(true);
        //添加分割线
//        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        adapter =new MyAdapter(datas);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter.setRecyclerItemClickListener(new MyAdapter.RecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(),"position---"+position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_recyclerview;
    }

    @Override
    protected DaggerBasePresenter creatPresenter() {
        return null;
    }

    @OnClick(R.id.tv_vertical)
    public void verticalAction(){
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @OnClick(R.id.tv_horizontal)
    public void horizontalAction(){
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    @OnClick(R.id.tv_grid)
    public void gridAction(){
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    @OnClick(R.id.tv_add)
    public void addAction(){
        adapter.addItem("sss",0);
    }

    @OnClick(R.id.tv_stragger)
    public void straggerAction(){
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
    }

}
