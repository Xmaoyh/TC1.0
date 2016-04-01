package com.example.tcwl_manage.controllers.activity;

import android.support.v4.app.Fragment;

import com.example.tcwl_manage.controllers.fragment.SendCarMapFragment;

/**
 * Created by MAOYH on 2016/3/15.
 * 派车实况
 */
public class SendCarMapActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return SendCarMapFragment.newInstance();
    }
}
