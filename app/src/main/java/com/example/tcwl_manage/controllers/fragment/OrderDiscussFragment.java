package com.example.tcwl_manage.controllers.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.models.enties.Order;
import com.example.tcwl_manage.models.services.ApiOrderdiscussService;
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
        orderDisscussAdapter = new OrderDisscussAdapter(orderData, getActivity());
        mOrderDisscussrecycler.setAdapter(orderDisscussAdapter);
    }

    private void initdata() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        RetrofitUtil retrofitUtil = new RetrofitUtil();
        ApiOrderdiscussService apiOrderdiscussService = retrofitUtil.create(ApiOrderdiscussService.class);
        apiOrderdiscussService.getOrderList(list)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Order>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Order order) {
                        orderData.add(order);
                    }
                });
    }
}
