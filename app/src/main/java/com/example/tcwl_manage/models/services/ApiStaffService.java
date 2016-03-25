package com.example.tcwl_manage.models.services;

import com.example.tcwl_manage.models.enties.StaffList;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by suanzi on 2016/3/23.
 */
public interface ApiStaffService {

    @GET("getStaffList")
    Observable<StaffList> getStafflist(@Query("page") int page);
}
