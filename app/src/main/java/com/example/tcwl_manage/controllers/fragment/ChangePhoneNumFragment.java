package com.example.tcwl_manage.controllers.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tcwl_manage.R;

/**
 * Created by MAOYH on 2016/4/5.
 * 修改手机号码
 */
public class ChangePhoneNumFragment extends Fragment {
    /**
     * 需要传递参数时有利于解耦
     */
    public static ChangePhoneNumFragment newInstance() {
        Bundle args = new Bundle();
        ChangePhoneNumFragment fragment = new ChangePhoneNumFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private Activity getMyActivity() {
        Activity act = getActivity();
        if (act == null) {
            act = this.getActivity();
        }
        return act;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.fragment_change_phone_num,null);
        return v;
    }
}
