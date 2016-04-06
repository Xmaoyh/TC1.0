package com.example.tcwl_manage.utils;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by MAOYH on 2016/4/5.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
    }
}
