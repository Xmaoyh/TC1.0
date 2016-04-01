package com.example.tcwl_manage.controllers.activity;

import android.support.v4.app.Fragment;

import com.example.tcwl_manage.controllers.fragment.BillingThirdFragment;

/**
 * Created by MAOYH on 2016/3/15.
 * 开单第三步
 */
public class BillingThirdActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return BillingThirdFragment.newInstance();
    }
}
