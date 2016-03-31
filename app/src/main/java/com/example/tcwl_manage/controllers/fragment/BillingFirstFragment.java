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
 * 开单第一步
 */
public class BillingFirstFragment extends Fragment {
    /**
     * 需要传递参数时有利于解耦
     */
    public static BillingFirstFragment newInstance() {
        Bundle args = new Bundle();
        BillingFirstFragment fragment = new BillingFirstFragment();
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
        View v = inflater.inflate(R.layout.fragment_billing_first,null);
        return  v;
    }
}
