package com.example.tcwl_manage.controllers.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.controllers.activity.OrderDiscussDetailActivity;
import com.example.tcwl_manage.models.enties.Order;
import com.example.tcwl_manage.models.services.ApiOrderService;
import com.example.tcwl_manage.utils.RetrofitUtil;
import com.example.tcwl_manage.views.adapters.OrderDisscussAdapter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by MAOYH on 2016/3/15.
 * 待接单-洽谈中
 */
public class OrderDiscussFragment extends Fragment {

    private View view;
    private XRecyclerView mOrderDisscussrecycler;
    private OrderDisscussAdapter orderDisscussAdapter;
    private List<Order> orderData = new ArrayList<Order>();
    private ApiOrderService apiOrderdiscussService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_order_discuss, container, false);
        init();
        return view;
    }

    private void init() {
        mOrderDisscussrecycler = (XRecyclerView) view.findViewById(R.id.order_discuss_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mOrderDisscussrecycler.setLayoutManager(layoutManager);

        mOrderDisscussrecycler.setRefreshProgressStyle(ProgressStyle.LineScale);
        mOrderDisscussrecycler.setLaodingMoreProgressStyle(ProgressStyle.BallGridPulse);
        mOrderDisscussrecycler.setArrowImageView(R.drawable.loading_11);

        mOrderDisscussrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //刷新
                orderData.clear();
                initdata();
                orderDisscussAdapter.notifyDataSetChanged();
                mOrderDisscussrecycler.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                //加载更多
            }
        });
        RetrofitUtil retrofitUtil = new RetrofitUtil();
        apiOrderdiscussService = retrofitUtil.create(ApiOrderService.class);
        orderDisscussAdapter = new OrderDisscussAdapter(orderData, getActivity());
        orderDisscussAdapter.setmOnItemListener(new OrderDisscussAdapter.OnItemListener() {
            @Override
            public void onItemClick(View view, int position) {
                //这里查看详情
                String  code = orderData.get(position - 1).getDateList().get(position-1).getCode();
                Intent intent = new Intent();
                intent.setClass(getActivity(), OrderDiscussDetailActivity.class);
                intent.putExtra("code",code);
                startActivityForResult(intent, Activity.RESULT_OK);
            }
        });
        mOrderDisscussrecycler.setAdapter(orderDisscussAdapter);
        initdata();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //requestCode标示请求的标示   resultCode表示有数据
        if (requestCode == Activity.RESULT_OK && resultCode == Activity.RESULT_OK) {
            initdata();
        }
    }

    private void initdata() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        apiOrderdiscussService.getOrderList(list)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Order>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        try {
                            Log.i("Log", e.getMessage());
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }catch (Throwable error){}


                    }

                    @Override
                    public void onNext(Order order) {
                        orderData.add(order);
                        orderDisscussAdapter.notifyDataSetChanged();
                    }
                });
    }
}
