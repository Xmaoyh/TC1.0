package com.example.tcwl_manage.controllers.activity;

import android.support.v4.app.Fragment;

import com.example.tcwl_manage.controllers.fragment.StaffManageFragment;

/**
 * Created by suanzi on 2016/3/15.
 * 员工管理
 */
public class StaffManageActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return StaffManageFragment.newInstance(1);
    }
}
