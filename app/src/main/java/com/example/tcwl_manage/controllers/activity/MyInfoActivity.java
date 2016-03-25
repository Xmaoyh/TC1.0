package com.example.tcwl_manage.controllers.activity;

import android.support.v4.app.Fragment;

import com.example.tcwl_manage.controllers.fragment.MyInfoFragment;

/**
 * Created by MAOYH on 2016/3/14.
 * 个人设置
 */
public class MyInfoActivity extends SingleFragmentActivity {
    protected Fragment createFragment() {
        return MyInfoFragment.newInstance();
    }
}
