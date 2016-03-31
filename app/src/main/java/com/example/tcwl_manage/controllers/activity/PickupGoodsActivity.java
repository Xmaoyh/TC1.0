package com.example.tcwl_manage.controllers.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.controllers.fragment.SendCarNotFragment;
import com.example.tcwl_manage.controllers.fragment.SendCarYesFragment;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MAOYH on 2016/3/24.
 * 待接送货
 */
public class PickupGoodsActivity extends AppCompatActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tl_fragment)
    SegmentTabLayout mTlFragment;
    @Bind(R.id.fl_change)
    FrameLayout mFlChange;
    @Bind(R.id.tv_function)
    TextView mTvFunction;
    private ArrayList<Fragment> mFragments;
    private String[] mTitles = {"未派车", "已派车"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup_goods);
        ButterKnife.bind(this);
        initData();


    }

    private void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(SendCarNotFragment.newInstance());
        mFragments.add(SendCarYesFragment.newInstance());
        //把第一个fragment加进去
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_change, mFragments.get(0))
                .commit();


        mTlFragment.setTabData(mTitles);
        mTlFragment.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                //切换fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_change, mFragments.get(position))
                        .commit();
                if (position == 0) {
                    mTvFunction.setVisibility(View.GONE);
                }
                if (position == 1) {
                    mTvFunction.setVisibility(View.VISIBLE);
                    mTvFunction.setText("派车");
                }

            }

            @Override
            public void onTabReselect(int position) {

            }
        });


    }

    @OnClick(R.id.iv_back)
    public void onClick() {
        finish();
    }
    @OnClick(R.id.tv_function)
    public void onFunctionClick() {
        startActivity(new Intent(this,MyInfoActivity.class));
    }
}
