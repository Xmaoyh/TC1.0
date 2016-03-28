package com.example.tcwl_manage.models.services;

import com.example.tcwl_manage.models.enties.Order;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by suanzi on 2016/3/25.
 */
public interface ApiOrderdiscussService {

    @GET("getOrderList")
    Observable<Order> getOrderList(@Query("status")ArrayList<Integer> status);
}
