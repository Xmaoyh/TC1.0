package com.example.tcwl_manage.controllers.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.controllers.fragment.MissionFragment;
import com.example.tcwl_manage.controllers.fragment.MyHomeFragment;
import com.example.tcwl_manage.models.enties.TabEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private CommonTabLayout mTabLayout;
    private String[] mTitles = {"任务", "管理", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_mission_unselect, R.mipmap.tab_manager_unselect,
            R.mipmap.tab_my_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_mission_select, R.mipmap.tab_manager_select,
            R.mipmap.tab_my_select};
    //tab的标题、选中图标、未选中图标
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initData();
        initView();
        //给tab设置数据和关联的fragment
        mTabLayout.setTabData(mTabEntities, this, R.id.fl_change, mFragments);
        //设置红点
        mTabLayout.showDot(1);
        mTabLayout.showMsg(0,88);

    }

    private void initView() {
        mTabLayout = (CommonTabLayout) findViewById(R.id.tl);
    }

    private void initData() {

        mFragments.add(new MissionFragment().newInstance());
        mFragments.add(new MissionFragment().newInstance());
        mFragments.add(new MyHomeFragment().newInstance());


        //设置tab的标题、选中图标、未选中图标
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
    }

}
