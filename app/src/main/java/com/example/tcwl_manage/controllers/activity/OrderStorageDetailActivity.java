package com.example.tcwl_manage.controllers.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.controllers.fragment.OrderStorageDetailFragment;

/**
 * Created by MAOYH on 2016/3/15.
 * 订单详情_待入库
 */
public class OrderStorageDetailActivity extends SingleFragmentActivity implements View.OnClickListener{

    private ImageView strorage_back;

    @Override
    protected Fragment createFragment() {
        Intent intent = getIntent();
        String code = intent.getStringExtra("code");
        return OrderStorageDetailFragment.newInstance(code);
    }

    private void init(){
        strorage_back = (ImageView) findViewById(R.id.strorage_back);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.strorage_back:
                finish();
                break;
        }
    }
}