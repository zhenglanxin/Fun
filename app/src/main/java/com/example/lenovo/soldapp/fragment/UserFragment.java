package com.example.lenovo.soldapp.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lenovo.soldapp.R;
import com.example.lenovo.soldapp.activity.OrderAcitivity;

/**
 * Created by lenovo on 2016/11/1.
 */
public class UserFragment extends Fragment {
    //获得页面的控件
    View view;
    private Button userBtnInformation;
    private Button userBtnOrder;

    //获得控件
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_user,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //用户信息按钮点击
        userBtnInformation=(Button)view.findViewById(R.id.user_btn_information);

        userBtnInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //订单信息按钮点击
        userBtnOrder=(Button)view.findViewById(R.id.user_btn_order);
        userBtnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), OrderAcitivity.class);
                startActivity(intent);
            }
        });
    }
}
