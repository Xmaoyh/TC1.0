package com.example.tcwl_manage.controllers.fragment;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.controllers.activity.MyInfoActivity;
import com.example.tcwl_manage.utils.GetCircleImage;

import java.io.File;

/**
 * Created by MAOYH on 2016/3/24.
 * 我的
 */
public class MyHomeFragment extends Fragment {
    private ImageView mIcon;
    private File outputImageIcon = new File(Environment.getExternalStorageDirectory() + "/Tangcan/tempImageIcon.jpg");

    /**
     * 需要传递参数时有利于解耦
     */
    public static MyHomeFragment newInstance() {
        Bundle args = new Bundle();
        MyHomeFragment fragment = new  MyHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_myhome, null);
        init(v);
        if (outputImageIcon.exists()) {
            mIcon.setImageBitmap(GetCircleImage.toRoundBitmap(BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/Tangcan/tempImageIcon.jpg")));
        }
        return v;
    }

    private void init(View v) {
        mIcon = (ImageView) v.findViewById(R.id.iv_my_icon_small);
        LinearLayout myLinearLayout = (LinearLayout) v.findViewById(R.id.linearlayout_myinfo);
        myLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MyInfoActivity.class));

            }
        });
    }

}
