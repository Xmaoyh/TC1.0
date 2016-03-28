package com.example.tcwl_manage.controllers.activity;

import android.support.v4.app.Fragment;

import com.example.tcwl_manage.controllers.fragment.RegisterFragment;

/**
 * Created by MAOYH on 2016/3/15.
 * 注册
 */
public class RegisterActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return RegisterFragment.newInstance();
    }
}
