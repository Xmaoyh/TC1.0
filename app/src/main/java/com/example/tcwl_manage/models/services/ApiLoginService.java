package com.example.tcwl_manage.models.services;

import com.example.tcwl_manage.models.enties.Login;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by MAOYH on 2016/3/25.
 */
public interface ApiLoginService {
    @POST("login?")
    Observable<Login> getLogin (@Query("registrationId") String registrationId,
                                @Query("appType") int appType,
                                @Query("password") String password,
                                @Query("mobileNo")int mobileNo);
}
