package com.example.tcwl_manage.controllers.activity;

import android.support.v4.app.Fragment;

import com.example.tcwl_manage.controllers.fragment.LoginFragment;

/**
 * Created by MAOYH on 2016/3/15.
 * 登入
 */
public class LoginActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return LoginFragment.newInstance();
    }
}
