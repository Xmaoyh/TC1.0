package com.example.tcwl_manage.controllers.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.controllers.fragment.OrderDiscussDetailFragment;

/**
 * Created by MAOYH on 2016/3/15.
 * 订单详情_洽谈中
 */
public class OrderDiscussDetailActivity extends SingleFragmentActivity implements View.OnClickListener{

    private ImageView detail_back;

    @Override
    protected Fragment createFragment() {
        Intent intent = getIntent();
        String code = intent.getStringExtra("code");
        return OrderDiscussDetailFragment.newInstance(code);
    }

    private void init(){
        detail_back = (ImageView) findViewById(R.id.detail_back);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.detail_back:
                finish();
                break;
        }
    }
}
