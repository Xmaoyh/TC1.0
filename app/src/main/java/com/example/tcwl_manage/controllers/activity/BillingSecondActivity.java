package com.example.tcwl_manage.controllers.activity;

import android.support.v4.app.Fragment;

import com.example.tcwl_manage.controllers.fragment.BillingSecondFragment;

/**
 * Created by MAOYH on 2016/3/15.
 * 开单第二步
 */
public class BillingSecondActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return BillingSecondFragment.newInstance();
    }
}
