package com.example.issuser.mvpdemo.test.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.issuser.mvpdemo.R;
import com.example.issuser.mvpdemo.test.Presenter.MainPresenter;
import com.example.issuser.mvpdemo.test.ToastUtil;
import com.example.issuser.mvpdemo.test.components.MainFragmentComponent;
import com.example.issuser.mvpdemo.test.view.IUserView;

import javax.inject.Inject;

/**
 * Created by john on 2018/3/18.
 */

public class MainFragement extends BaseFragment implements IUserView{

    @Inject
    MainPresenter mainPresenter;
    @Inject
    ToastUtil toastUtil;

    private MainFragmentComponent mainFragmentComponent;
    private OnFragmentInteractionListener mListener;
    public MainFragement(){

    }

    public static MainFragement newInstance(String params){
        MainFragement mainFragement=new MainFragement();
        Bundle args=new Bundle();
        return mainFragement;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity()instanceof Main2Activity){
            mainFragmentComponent=((Main2Activity)getActivity()).getMainComponent().mainFragmentComponent();
            mainFragmentComponent.inject(this);
            mainPresenter.setUserView(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        view.findViewById(R.id.get_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainPresenter.getUser();
            }
        });
        view.findViewById(R.id.show_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastUtil.showToast("依赖注入获取到的toast");
            }
        });
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }



    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void setUserName(String name) {
        ((TextView)getView().findViewById(R.id.user_info)).setText(name);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
