package com.jikansoftware.retrofitgetsencillo.services;

import com.jikansoftware.retrofitgetsencillo.model.Ip;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IpService {

    @GET("/")
    Call<Ip> getIp();
}
