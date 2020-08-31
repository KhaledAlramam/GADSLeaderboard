package com.chucky.gadsleaderboard.data.remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        val webservice: APIService by lazy {
            Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(APIService::class.java)
        }


        val webservice2: APIService by lazy {
            Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(APIService::class.java)
        }


    }

}