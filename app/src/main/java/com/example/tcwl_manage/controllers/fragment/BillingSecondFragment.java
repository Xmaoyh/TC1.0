package com.example.tcwl_manage.controllers.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.controllers.activity.BillingThirdActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MAOYH on 2016/3/15.
 * 开单第二步
 */
public class BillingSecondFragment extends Fragment {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.btn_next)
    Button mBtnNext;

    /**
     * 需要传递参数时有利于解耦
     */
    public static BillingSecondFragment newInstance() {
        Bundle args = new Bundle();
        BillingSecondFragment fragment = new BillingSecondFragment();
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
        View v = inflater.inflate(R.layout.fragment_billing_second, null);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick({R.id.iv_back, R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                getMyActivity().finish();
                break;
            case R.id.btn_next:
                startActivity(new Intent(getMyActivity(), BillingThirdActivity.class));
                break;
        }
    }
}
