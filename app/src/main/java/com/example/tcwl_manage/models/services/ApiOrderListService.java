package com.example.tcwl_manage.models.services;

import com.example.tcwl_manage.models.enties.OrderList;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by suanzi on 2016/3/25.
 */
public interface ApiOrderListService {

    @GET("getOrderList")
    Observable<OrderList> getOrderList(@Query("isDispatch") int isDispatch,@Query("status") ArrayList<Integer> status);
}
