package com.example.tcwl_manage.controllers.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.controllers.activity.MyInfoActivity;
import com.example.tcwl_manage.controllers.activity.SendCarListActivity;
import com.example.tcwl_manage.models.enties.OrderList;
import com.example.tcwl_manage.models.services.ApiOrderListService;
import com.example.tcwl_manage.utils.RetrofitUtil;
import com.example.tcwl_manage.utils.ToastUtil;
import com.example.tcwl_manage.views.adapters.SendCarNotAdapter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by MAOYH on 2016/3/15.
 * 待接送货-未派车
 */
public class SendCarNotFragment extends Fragment {
    @Bind(R.id.x_recycle)
    XRecyclerView mXRecycle;
    @Bind(R.id.tv_order_num)
    TextView mTvOrderNum;
    @Bind(R.id.tv_volume)
    TextView mTvVolume;
    @Bind(R.id.tv_weight)
    TextView mTvWeight;
    @Bind(R.id.btn_send_car)
    Button mBtnSendCar;


    /*订单信息*/
    private List<OrderList> mOrderLists = new ArrayList<>();
    /* 未派车列表的适配器*/
    private SendCarNotAdapter mSendCarNotAdapter;
    private int mOderNum = 0;
    private double mVolume = 0;
    private double mWight = 0;


    /**
     * 需要传递参数时有利于解耦
     */
    public static SendCarNotFragment newInstance() {
        Bundle args = new Bundle();
        SendCarNotFragment fragment = new SendCarNotFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private Activity getMyActivity() {
        Activity act = getActivity();
        if (act == null) {
            act = this.getActivity();
        }
        return act;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragement_sendcar_not, null);
        ButterKnife.bind(this, v);
        initView();
        return v;
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getMyActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mXRecycle.setLayoutManager(layoutManager);
        //设置下拉刷新样式
        mXRecycle.setRefreshProgressStyle(ProgressStyle.LineScale);
        //设置上拉加载样式
        mXRecycle.setLaodingMoreProgressStyle(ProgressStyle.BallGridPulse);
        //设置下拉箭头样式
        mXRecycle.setArrowImageView(R.drawable.loading_11);
        //设置下拉刷新和上拉加载的监听
        mXRecycle.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mOrderLists.clear();
                initData();
                mXRecycle.refreshComplete();

            }

            @Override
            public void onLoadMore() {

            }
        });
        //设置适配器
        mSendCarNotAdapter = new SendCarNotAdapter(getMyActivity(), mOrderLists);
        mSendCarNotAdapter.setOnItemClickListener(new SendCarNotAdapter.OnItemClickListener() {
            @Override
            public void onDataClick(int position) {
                startActivity(new Intent(getMyActivity(), MyInfoActivity.class));
            }

            @Override
            public void onCheckBoxClick(double volume, double wight) {
                mTvOrderNum.setText(String.valueOf(mOderNum += 1));
                mTvVolume.setText(String.valueOf(mVolume += volume));
                mTvWeight.setText(String.valueOf(mWight += wight));
            }

            @Override
            public void onCheckBoxUnClick(double volume, double wight) {
                mTvOrderNum.setText(String.valueOf(mOderNum -= 1));
                mTvVolume.setText(String.valueOf(mVolume -= volume));
                mTvWeight.setText(String.valueOf(mWight -= wight));
            }


        });
        mXRecycle.setAdapter(mSendCarNotAdapter);
        //显示数据
        initData();

    }

    private void initData() {
        //请求数组
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        //请求api
        RetrofitUtil mRetrofitUtil = new RetrofitUtil();
        ApiOrderListService apiOrderListService = mRetrofitUtil.create(ApiOrderListService.class);
        Observable<OrderList> observable = apiOrderListService.getOrderList(0, list);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<OrderList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtil.toast(getMyActivity(), getMyActivity().getResources().getString(R.string.network_error));
                    }

                    @Override
                    public void onNext(OrderList orderList) {
                        mOrderLists.add(orderList);
                        mSendCarNotAdapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick(R.id.btn_send_car)
    public void onClick() {
        startActivity(new Intent(getMyActivity(), SendCarListActivity.class));
    }
}
