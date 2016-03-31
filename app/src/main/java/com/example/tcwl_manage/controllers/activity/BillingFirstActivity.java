package com.example.tcwl_manage.controllers.activity;

import android.support.v4.app.Fragment;

import com.example.tcwl_manage.controllers.fragment.BillingFirstFragment;

/**
 * Created by MAOYH on 2016/3/15.
 * 开单第一步
 */
public class BillingFirstActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return BillingFirstFragment.newInstance();
    }
}
