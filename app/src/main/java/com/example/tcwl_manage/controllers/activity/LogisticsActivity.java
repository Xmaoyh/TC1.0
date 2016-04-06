package com.example.tcwl_manage.controllers.activity;


import android.support.v4.app.Fragment;

import com.example.tcwl_manage.controllers.fragment.LogisticsFragment;

/**
 * Created by MAOYH on 2016/3/9.
 * 物流
 */
public class LogisticsActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return LogisticsFragment.newInstance();
    }
}
