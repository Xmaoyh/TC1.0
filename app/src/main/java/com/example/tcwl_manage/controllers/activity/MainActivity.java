package com.example.tcwl_manage.controllers.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.controllers.fragment.MissionFragment;
import com.example.tcwl_manage.controllers.fragment.MyHomeFragment;
import com.example.tcwl_manage.models.enties.TabEntity;
import com.example.tcwl_manage.utils.ToastUtil;
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
    /** 用于对返回键按下次数的计数 */
    private int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("activity", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initData();
        //给tab设置数据和关联的fragment
        mTabLayout.setTabData(mTabEntities, this, R.id.fl_change, mFragments);
//        //设置红点
//        mTabLayout.showDot(1);
//        mTabLayout.showMsg(0,88);

    }


    public void onSaveInstanceState(Bundle outState) {
        Log.e("activity", "onSaveInstanceState");
        // TODO Auto-generated method stub
        //super.onSaveInstanceState(outState);   //将这一行注释掉，阻止activity保存fragment的状态

    }


    private void initView() {
        mTabLayout = (CommonTabLayout) findViewById(R.id.tl);
    }

    private void initData() {

        mFragments.add(MissionFragment.newInstance());
        mFragments.add(MissionFragment.newInstance());
        mFragments.add(MyHomeFragment.newInstance());


        //设置tab的标题、选中图标、未选中图标
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
    }

    /**
     * 重写点击返回按钮方法，点击一次土司提示，两次退出程序
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ( i == 0) {// 若只按下一次
                ToastUtil.toast(this,"再按一次退出程序");
                i++;
            } else{// 若按下两次
              finish();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

}
