package com.example.tcwl_manage.controllers.activity;

import android.support.v4.app.Fragment;

import com.example.tcwl_manage.controllers.fragment.ChangePhoneNumFragment;

/**
 * Created by MAOYH on 2016/3/15.
 * 修改手机号码
 */
public class ChangePhoneNumActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return ChangePhoneNumFragment.newInstance();
    }
}
