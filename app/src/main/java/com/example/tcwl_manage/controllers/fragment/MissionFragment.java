package com.example.tcwl_manage.controllers.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.controllers.activity.OrderActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by MAOYH on 2016/3/24.
 * 任务
 */
public class MissionFragment extends Fragment{
    private static View v = null;
    @Bind(R.id.top)
    RelativeLayout mTop;
    @Bind(R.id.IV_kaidan)
    ImageView mIVKaidan;
    @Bind(R.id.kaidan)
    RelativeLayout mKaidan;
    @Bind(R.id.iv_songhuo)
    ImageView mIvSonghuo;
    @Bind(R.id.iv_jiedan)
    ImageView mIvJiedan;
    @Bind(R.id.iv_wuliu)
    ImageView mIvWuliu;
    @Bind(R.id.iv_kucun)
    ImageView mIvKucun;

    public static  MissionFragment newInstance() {
        Bundle args = new Bundle();
        MissionFragment fragment = new  MissionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        v = inflater.inflate(R.layout.fragment_mission, null);
        ButterKnife.bind(this, v);
        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    @OnClick(R.id.iv_jiedan)
    public void setmIvJiedan(){

        Intent intent = new Intent();
        intent.setClass(getActivity(), OrderActivity.class);
        startActivity(intent);
    }

}
