package com.example.tcwl_manage.controllers.activity;

import android.support.v4.app.Fragment;

import com.example.tcwl_manage.controllers.fragment.ResetPWFragment;

/**
 * Created by MAOYH on 2016/3/15.
 * 重置密码
 */
public class ResetPWActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return ResetPWFragment.newInstance();
    }
}
