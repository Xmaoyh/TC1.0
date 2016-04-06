package com.example.tcwl_manage.controllers.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.models.enties.OrderList;
import com.example.tcwl_manage.models.services.ApiOrderListService;
import com.example.tcwl_manage.utils.RetrofitUtil;
import com.example.tcwl_manage.utils.ToastUtil;
import com.example.tcwl_manage.views.adapters.SendCarYesAdapter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by MAOYH on 2016/3/15.
 */
public class SendCarYesFragment extends Fragment {
    @Bind(R.id.x_recycle)
    XRecyclerView mXRecycle;
    /* 订单信息*/
    private List<OrderList> mOrderLists = new ArrayList<>();
    /* 已派车列表的适配器*/
    private SendCarYesAdapter mSendCarYesAdapter;
    private  RetrofitUtil mRetrofitUtil ;


    /**
     * 需要传递参数时有利于解耦
     */
    public static SendCarYesFragment newInstance() {
        Bundle args = new Bundle();
        SendCarYesFragment fragment = new SendCarYesFragment();
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragement_sendcar_yes, null);
        ButterKnife.bind(this, v);
        initView();
        return v;
    }

    private void initView() {
        mRetrofitUtil = new RetrofitUtil();
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
        mSendCarYesAdapter = new SendCarYesAdapter(getMyActivity(), mOrderLists);
        mXRecycle.setAdapter(mSendCarYesAdapter);
        //显示数据
        initData();
    }

    private void initData() {
        //请求数组
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        //请求api
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
                        //ToastUtil.toast(getMyActivity(), getMyActivity().getResources().getString(R.string.network_error));
                        try {
                            ToastUtil.toast(getMyActivity(), e.getMessage());
                        }catch (Throwable error){}
                    }

                    @Override
                    public void onNext(OrderList orderList) {
                        mOrderLists.add(orderList);
                        mSendCarYesAdapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
