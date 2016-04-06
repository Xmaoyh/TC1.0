package com.example.tcwl_manage.models.services;

import com.example.tcwl_manage.models.enties.Codes;
import com.example.tcwl_manage.models.enties.OKOrder;
import com.example.tcwl_manage.models.enties.Order;
import com.example.tcwl_manage.models.enties.OrderInfo;
import com.example.tcwl_manage.models.enties.UpdateStatus;

import java.util.ArrayList;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by suanzi on 2016/3/25.
 * 待接单的服务接口
 */
public interface ApiOrderService {

    //查询订单列表，待洽谈中
    @GET("getOrderList")
    Observable<Order> getOrderList(@Query("status")ArrayList<Integer> status);

    //查询订单列表，待入库
    @POST("updateStatus")
    Observable<Order> getOrderStorageList(@Query("status")ArrayList<Integer> status);

    //查询详情列表－待洽谈中
    @GET("getOrderInfo")
    Observable<OrderInfo> getDisscussDetail(@Query("code")String code);

    //修改订单
    @POST("confirmOrder")
    Observable<Codes> Okorder(@Body OKOrder okOrder);

    //确定入库
    @POST("updateStatus")
    Observable<Codes> okupdateStatus(@Body UpdateStatus status);

}
