package com.denybrabo.imgurcats.model

import androidx.lifecycle.MutableLiveData
import com.denybrabo.imgurcats.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataRepository {

    private var dataModel = MutableLiveData<DataModel>()

    fun getAnimals(search: String): MutableLiveData<DataModel>{

        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.imgur.com/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var service = retrofit.create(ApiService::class.java)
        var call: Call<DataModel> = service.getAnimals("Client-ID 1ceddedc03a5d71", search)

        call.enqueue(object : Callback<DataModel>{
            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                dataModel.value = response.body()
            }

            override fun onFailure(call: Call<DataModel>, t: Throwable) {
            }
        })

        return dataModel
    }
}