package com.egg.everylogg.activity

import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetorifitService {

    // 페이지
    @GET("api/user/find/{id}")
    fun getUser(@Path("id") id: String): retrofit2.Call<ExampleResponse.User>

    // 로그인
    @POST("api/login")
    fun
}