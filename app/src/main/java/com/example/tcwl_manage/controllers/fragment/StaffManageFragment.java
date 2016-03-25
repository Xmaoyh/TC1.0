package com.example.tcwl_manage.controllers.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.models.enties.StaffList;
import com.example.tcwl_manage.models.services.ApiStaffService;
import com.example.tcwl_manage.utils.RetrofitUtil;
import com.example.tcwl_manage.views.adapters.MyAdapter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by suanzi on 2016/3/23.
 * 员工管理fragment，真正的内容区域
 */
public class StaffManageFragment extends Fragment {

    private XRecyclerView mRecyclerView;
    private int refreshTime = 0;
    private int times = 0;
    private ArrayList<String> listData;
    private MyAdapter mAdapter;
    private View view;

    public static StaffManageFragment newInstance(int userId) {
        Bundle args = new Bundle();
        args.putInt("USER_ID", userId);
        StaffManageFragment fragment = new StaffManageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_staff_manage, container, false);
        text1();
        return view;
    }

    private void text1() {

        mRecyclerView = (XRecyclerView) view.findViewById(R.id.staff_all_recylist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setRefreshProgressStyle(ProgressStyle.LineScale);
        mRecyclerView.setLaodingMoreProgressStyle(ProgressStyle.BallGridPulse);
        mRecyclerView.setArrowImageView(R.drawable.loading_11);

        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refreshTime++;
                times = 0;
                new Handler().postDelayed(new Runnable() {
                    public void run() {

                        listData.clear();
                        for (int i = 0; i < 15; i++) {
                            listData.add("item" + i + "after " + refreshTime + " times of refresh");
                        }
                        mAdapter.notifyDataSetChanged();
                        mRecyclerView.refreshComplete();
                    }

                }, 1000);
            }

            @Override
            public void onLoadMore() {
                if (times < 2) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            mRecyclerView.loadMoreComplete();
                            for (int i = 0; i < 15; i++) {
                                listData.add("item" + (i + listData.size()));
                            }
                            mAdapter.notifyDataSetChanged();
                            mRecyclerView.refreshComplete();
                        }
                    }, 1000);
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {

                            mAdapter.notifyDataSetChanged();
                            mRecyclerView.loadMoreComplete();
                        }
                    }, 1000);
                }
                times++;
            }
        });
        listData = new ArrayList<String>();
        for (int i = 0; i < 15; i++) {
            listData.add("item" + (i + listData.size()));
        }
        mAdapter = new MyAdapter(listData);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void stafflist() {
        RetrofitUtil retrofitUtil = new RetrofitUtil();
        ApiStaffService apiStaffService = retrofitUtil.create(ApiStaffService.class);
        apiStaffService.getStafflist(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<StaffList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("Log", e.getMessage().toString());
                    }

                    @Override
                    public void onNext(StaffList staffList) {

                    }
                });

    }
}
