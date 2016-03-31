package com.example.tcwl_manage.controllers.activity;

import android.support.v4.app.Fragment;

import com.example.tcwl_manage.controllers.fragment.SendCarListFragment;

/**
 * Created by MAOYH on 2016/3/15.
 * 派车_列表模式
 */
public class SendCarListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return SendCarListFragment.newInstance();
    }
}
