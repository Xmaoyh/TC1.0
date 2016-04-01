package com.example.tcwl_manage.controllers.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.controllers.activity.SendCarMapActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MAOYH on 2016/3/15.
 * 派车-列表模式
 */
public class SendCarListFragment extends Fragment {
    @Bind(R.id.imagev_turn_back)
    ImageView mImagevTurnBack;
    @Bind(R.id.iv_send_cap_map)
    ImageView mIvSendCapMap;

    /**
     * 需要传递参数时有利于解耦
     */
    public static SendCarListFragment newInstance() {
        Bundle args = new Bundle();
        SendCarListFragment fragment = new SendCarListFragment();
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
        View v = inflater.inflate(R.layout.fragment_send_car_list, null);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.imagev_turn_back, R.id.iv_send_cap_map})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imagev_turn_back:
                getMyActivity().finish();
                break;
            case R.id.iv_send_cap_map:
                startActivity(new Intent(getMyActivity(), SendCarMapActivity.class));
                break;
        }
    }
}
