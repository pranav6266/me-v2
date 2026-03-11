package com.pranav.mev2.data.api

import retrofit2.Call
import retrofit2.http.GET

interface MeApi {

    @GET("health")
    fun health(): Call<String>

}