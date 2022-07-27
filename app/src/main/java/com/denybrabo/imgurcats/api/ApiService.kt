package com.denybrabo.imgurcats.api

import com.denybrabo.imgurcats.model.DataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("/3/gallery/search/")
    fun getAnimals(
        @Header("Authorization") authorization: String,
        @Query("q") query: String
    ): Call<DataModel>

}