package com.example.tcwl_manage.controllers.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.controllers.activity.MyInfoActivity;

/**
 * Created by MAOYH on 2016/3/24.
 * 我的
 */
public class MyHomeFragment extends Fragment {
    /**
     * 需要传递参数时有利于解耦
     */
    public static MyHomeFragment newInstance() {
        Bundle args = new Bundle();
        MyHomeFragment fragment = new MyHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_myhome, null);
        init(v);
        return v;
    }
    private void init( View v) {
        LinearLayout myLinearLayout = (LinearLayout) v.findViewById(R.id.linearlayout_myinfo);
        myLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MyInfoActivity.class));
            }
        });
    }

}
