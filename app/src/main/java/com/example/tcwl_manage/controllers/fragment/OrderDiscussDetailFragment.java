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
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.models.enties.Codes;
import com.example.tcwl_manage.models.enties.OKOrder;
import com.example.tcwl_manage.models.enties.OrderInfo;
import com.example.tcwl_manage.models.services.ApiOrderService;
import com.example.tcwl_manage.utils.RetrofitUtil;
import com.example.tcwl_manage.view.RecycleviewForScollView;
import com.example.tcwl_manage.views.adapters.DetailGoodsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by MAOYH on 2016/3/15.
 * 订单详情_洽谈中
 */
public class OrderDiscussDetailFragment extends Fragment {

    @Bind(R.id.code)
    TextView txcode;
    @Bind(R.id.orderNoManual)
    TextView orderNoManual;
    @Bind(R.id.detail_sendingPerson)
    TextView sendingPerson;
    @Bind(R.id.detail_sendingUnit)
    TextView sendingUnit;
    @Bind(R.id.detail_sendingPhoneNo)
    TextView sendingPhoneNo;
    @Bind(R.id.detail_sendingAddr)
    TextView sendingAddr;
    @Bind(R.id.detail_pickingWay)
    TextView pickingWay;
    @Bind(R.id.detail_initDate)
    TextView initDate;
    @Bind(R.id.detail_receivingPerson)
    TextView receivingPerson;
    @Bind(R.id.detail_receivingUint)
    TextView receivingUint;
    @Bind(R.id.detail_receivingPhoneNo)
    TextView receivingPhoneNo;
    @Bind(R.id.detail_receivingAddr)
    TextView receivingAddr;
    @Bind(R.id.detail_deliverWay)
    TextView deliverWay;
    @Bind(R.id.detail_payMethod)
    TextView payMethod;
    @Bind(R.id.detail_isReceipt)
    TextView isReceipt;
    @Bind(R.id.detail_totalgoodsnumber)
    TextView totalgoodsnumber;
    @Bind(R.id.detail_totalgoodsfre)
    TextView totalgoodsfre;
    @Bind(R.id.detail_totalTransportFee)
    TextView totalTransportFee;
    @Bind(R.id.detail_totalStoringFee)
    TextView totalStoringFee;
    @Bind(R.id.detail_totalPickingFee)
    TextView totalPickingFee;
    @Bind(R.id.detail_totalDeliveryFee)
    TextView totalDeliveryFee;
    @Bind(R.id.detail_totalFockFee)
    TextView totalFockFee;
    @Bind(R.id.detail_totalLoadingFee)
    TextView totalLoadingFee;
    @Bind(R.id.detail_totalOtherFee)
    TextView totalOtherFee;
    @Bind(R.id.detail_totalInsuranceFee)
    TextView totalInsuranceFee;
    @Bind(R.id.detail_totalFee)
    TextView otalFee;
    @Bind(R.id.detail_save)
    TextView detail_save;
    @Bind(R.id.detail_ok)
    TextView detail_ok;

    private View view;
    private DetailGoodsAdapter mAdapter;
    private List<OrderInfo> orderInfos;
    private static String codenumber;

    private RecycleviewForScollView goods_recycle1;
    private RetrofitUtil retrofitUtil;
    private ApiOrderService apiOrderService;
    private OKOrder okOrder = new OKOrder();


    public static OrderDiscussDetailFragment newInstance(String code) {
        Bundle args = new Bundle();
        args.putString("CODE", code);
        codenumber = code;
        OrderDiscussDetailFragment fragment = new OrderDiscussDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.order_disscuss_detail, container, false);
        ButterKnife.bind(this, view);
        init();
        initData(codenumber);
        return view;
    }

    private void init() {
        //设置recycleview的方向
        goods_recycle1 = (RecycleviewForScollView) view.findViewById(R.id.detail_goods_recycle1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        goods_recycle1.setLayoutManager(layoutManager);

        orderInfos = new ArrayList<>();
        mAdapter = new DetailGoodsAdapter(getActivity(), orderInfos);
        goods_recycle1.setAdapter(mAdapter);

        retrofitUtil = new RetrofitUtil();
        apiOrderService = retrofitUtil.create(ApiOrderService.class);
    }

    private void initData(String code) {
        apiOrderService
                .getDisscussDetail(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<OrderInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("log", e.getMessage());
                    }

                    @Override
                    public void onNext(OrderInfo orderInfo) {
                        if (orderInfo != null) {
                            orderInfos.add(orderInfo);
                            txcode.setText(orderInfo.getCode());
                            orderNoManual.setText(orderInfo.getOrderNoManual());
                            sendingPerson.setText(orderInfo.getSendingPerson());
                            sendingUnit.setText(orderInfo.getSendingUnit());
                            sendingPhoneNo.setText(String.valueOf(orderInfo.getSendingPhoneNo()));
                            sendingAddr.setText(orderInfo.getSendingAddr());
                            if (orderInfo.getPickingWay() == 0) {
                                pickingWay.setText("无需接货");
                            } else {
                                pickingWay.setText("需要接货");
                            }
                            initDate.setText(orderInfo.getInitDate());
                            receivingPerson.setText(orderInfo.getReceivingPerson());
                            receivingUint.setText(orderInfo.getReceivingUint());
                            receivingPhoneNo.setText(String.valueOf(orderInfo.getReceivingPhoneNo()));
                            receivingAddr.setText(orderInfo.getReceivingAddr());
                            if (orderInfo.getDeliverWay() == 0) {
                                deliverWay.setText("无需送货");
                            } else {
                                deliverWay.setText("需要送货");
                            }
                            switch (orderInfo.getPayMethod()) {
                                case 1:
                                    payMethod.setText("现付");
                                    break;
                                case 2:
                                    payMethod.setText("提付");
                                    break;
                                case 3:
                                    payMethod.setText("月结");
                                    break;
                                case 4:
                                    payMethod.setText("欠付");
                                    break;
                            }
                            if (orderInfo.isIsReceipt()) {
                                isReceipt.setText("需要回单");
                            } else {
                                isReceipt.setText("无需回单");
                            }
                            mAdapter.notifyDataSetChanged();
                            //清单费用
                            totalgoodsnumber.setText("欠缺字段");
                            totalgoodsfre.setText("欠缺字段");
                            totalTransportFee.setText(String.valueOf(orderInfo.getTotalTransportFee()));
                            totalStoringFee.setText(String.valueOf(orderInfo.getTotalStoringFee()));
                            totalPickingFee.setText(String.valueOf(orderInfo.getTotalPickingFee()));
                            totalInsuranceFee.setText(String.valueOf(orderInfo.getTotalInsuranceFee()));
                            totalDeliveryFee.setText(String.valueOf(orderInfo.getTotalDeliveryFee()));
                            totalFockFee.setText(String.valueOf(orderInfo.getTotalFockFee()));
                            totalLoadingFee.setText(String.valueOf(orderInfo.getTotalLoadingFee()));
                            totalOtherFee.setText(String.valueOf(orderInfo.getTotalOtherFee()));
                            otalFee.setText(String.valueOf("1111"));
                        }

                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.detail_save, R.id.detail_ok})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.detail_save:
                saveOrOk(1);
                break;
            case R.id.detail_ok:
                //确定
                saveOrOk(2);
                break;
        }
    }

    private void saveOrOk(int actionType) {
        okOrder.setActionType(actionType);
        okOrder.setTotalDeliveryFee(Integer.parseInt(totalDeliveryFee.getText().toString()));
        okOrder.setTotalFockFee(Integer.parseInt(totalFockFee.getText().toString()));
        okOrder.setTotalInsuranceFee(Integer.parseInt(totalInsuranceFee.getText().toString()));
        okOrder.setTotalLoadingFee(Integer.parseInt(totalLoadingFee.getText().toString()));
        okOrder.setTotalOtherFee(Integer.parseInt(totalOtherFee.getText().toString()));
        okOrder.setTotalPickingFee(Integer.parseInt(totalPickingFee.getText().toString()));
        okOrder.setTotalStoringFee(Integer.parseInt(totalStoringFee.getText().toString()));
        okOrder.setTotalTransportFee(Integer.parseInt(totalTransportFee.getText().toString()));
        okOrder.setCode(codenumber);
        okOrder.setUserCode("登录人");

        apiOrderService.Okorder(okOrder)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Codes>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        int a=0;
                    }

                    @Override
                    public void onNext(Codes codes) {
                        String code =  String.valueOf(codes.getCode());
                        Toast.makeText(getActivity(),code,Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        //把返回数据存入Intent
                        intent.putExtra("result", "My name is linjiqin");
                        //设置返回数据
                        getActivity().setResult(Activity.RESULT_OK);
                        getActivity().finish();
                    }
                });

    }

}
