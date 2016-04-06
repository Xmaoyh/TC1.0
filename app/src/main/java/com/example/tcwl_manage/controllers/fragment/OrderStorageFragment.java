package com.example.tcwl_manage.controllers.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
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
import com.example.tcwl_manage.controllers.activity.OrderStorageDetailActivity;
import com.example.tcwl_manage.models.enties.Codes;
import com.example.tcwl_manage.models.enties.Order;
import com.example.tcwl_manage.models.enties.UpdateStatus;
import com.example.tcwl_manage.models.services.ApiOrderService;
import com.example.tcwl_manage.utils.RetrofitUtil;
import com.example.tcwl_manage.views.adapters.OrderStorageAdapter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by MAOYH on 2016/3/15.
 * 待接单-待入库
 */
public class OrderStorageFragment extends Fragment {

    private View view;
    private XRecyclerView mOrderstoragerecycler;
    private OrderStorageAdapter orderStorageAdapter;
    private List<Order> orderData = new ArrayList<Order>();
    private ApiOrderService apiOrderService;
    private ProgressDialog progressDialog;
    private  UpdateStatus updateStatus = new UpdateStatus();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_order_storage, container, false);
        init();
        return view;
    }

    private void init(){
        progressDialog = new ProgressDialog(getActivity());
        //设置进度条风格，风格为圆形，旋转的
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(false);
        mOrderstoragerecycler = (XRecyclerView) view.findViewById(R.id.order_storage_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mOrderstoragerecycler.setLayoutManager(layoutManager);

        mOrderstoragerecycler.setRefreshProgressStyle(ProgressStyle.LineScale);
        mOrderstoragerecycler.setLaodingMoreProgressStyle(ProgressStyle.BallGridPulse);
        mOrderstoragerecycler.setArrowImageView(R.drawable.loading_11);

        mOrderstoragerecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //刷新
                orderData.clear();
                initdata();
                orderStorageAdapter.notifyDataSetChanged();
                mOrderstoragerecycler.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                //加载更多
            }
        });
        RetrofitUtil retrofitUtil = new RetrofitUtil();
        apiOrderService = retrofitUtil.create(ApiOrderService.class);
        orderStorageAdapter = new OrderStorageAdapter(orderData, getActivity());
        orderStorageAdapter.setMonItemListener(new OrderStorageAdapter.OnItemListener() {
            @Override
            public void onItemClick(View view, int position) {
                //点击每一个item查看
                //这里查看详情
                String  code = orderData.get(position - 1).getDateList().get(position-1).getCode();
                Intent intent = new Intent();
                intent.setClass(getActivity(), OrderStorageDetailActivity.class);
                intent.putExtra("code",code);
                startActivityForResult(intent, Activity.RESULT_OK);
            }
        });
        orderStorageAdapter.setBtnListener(new OrderStorageAdapter.OnBtnListener() {
            @Override
            public void onBtnClick(View view, int position) {
                String mcode = orderData.get(position-1).getDateList().get(position-1).getCode();
                updateStatus.setCode(mcode);
                updateStatus.setStatus(3);
                updateStatus.setUserCode("登录人");

                apiOrderService.okupdateStatus(updateStatus)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Codes>() {
                            @Override
                            public void call(Codes codes) {
                                Toast.makeText(getActivity(),codes+"",Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        mOrderstoragerecycler.setAdapter(orderStorageAdapter);
        initdata();
    }

    private void initdata(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        apiOrderService.getOrderList(list)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        progressDialog.show();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread()) // 指定主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Order>() {
                    @Override
                    public void onCompleted() {
                        Log.i("Log","onCompleted");
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        try {
                            Log.i("Log", e.getMessage());
                            progressDialog.dismiss();
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }catch (Throwable error){}
                    }

                    @Override
                    public void onNext(Order order) {
                        orderData.add(order);
                        orderStorageAdapter.notifyDataSetChanged();
                    }
                });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
