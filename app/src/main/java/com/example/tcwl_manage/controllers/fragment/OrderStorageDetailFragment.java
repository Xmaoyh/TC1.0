package com.example.tcwl_manage.controllers.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tcwl_manage.R;

/**
 * Created by MAOYH on 2016/3/15.
 * 订单详情_待入库
 */
public class OrderStorageDetailFragment extends Fragment{

    private View view;
    private static String codenumber;

    public static OrderStorageDetailFragment newInstance(String code) {
        Bundle args = new Bundle();
        args.putString("CODE", code);
        codenumber = code;
        OrderStorageDetailFragment fragment = new OrderStorageDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_order_storagedetail,container,false);
        return view;
    }
}
