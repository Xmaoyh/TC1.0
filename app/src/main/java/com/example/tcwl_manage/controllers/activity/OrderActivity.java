package com.example.tcwl_manage.controllers.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.controllers.fragment.OrderDiscussFragment;
import com.example.tcwl_manage.controllers.fragment.OrderStorageFragment;

/**
 * Created by MAOYH on 2016/3/15.
 * 待接单
 */
public class OrderActivity extends FragmentActivity implements View.OnClickListener {


    private RadioButton rad_storage, rad_disscuss;
    private ImageView mback;
    private OrderDiscussFragment orderDiscussFragment;
    private OrderStorageFragment orderStorageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        init();
    }

    private void init() {
        rad_disscuss = (RadioButton) findViewById(R.id.rad_disscuss);
        rad_storage = (RadioButton) findViewById(R.id.rad_storage);
        mback = (ImageView) findViewById(R.id.order_back);
        rad_disscuss.setOnClickListener(this);
        rad_storage.setOnClickListener(this);
        mback.setOnClickListener(this);
        getViewfragment(0);
    }

    //切换
    private void getViewfragment(int fragmentType) {
        Fragment fragentview = null;

        switch (fragmentType) {
            case 0:
                if (orderDiscussFragment == null) {
                    orderDiscussFragment = new OrderDiscussFragment();
                }
                fragentview = orderDiscussFragment;
                break;
            case 1:
                if (orderStorageFragment == null) {
                    orderStorageFragment = new OrderStorageFragment();
                }
                fragentview = orderStorageFragment;
                break;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.order_fragment_layout, fragentview)
                .commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rad_disscuss:
                getViewfragment(0);
                break;
            case R.id.rad_storage:
                getViewfragment(1);
                break;
            case R.id.order_back:
                finish();
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
