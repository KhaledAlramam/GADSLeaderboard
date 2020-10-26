package com.chucky.gadsleaderboard.data.remote

import com.github.simonpercic.oklog3.OkLogInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class RetrofitClient {
    companion object {
        val webservice: APIService by lazy {
            Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build().create(APIService::class.java)
        }


        val webservice2: APIService by lazy {
            val okLogInterceptor = OkLogInterceptor.builder().build()

            val okHttpBuilder = OkHttpClient.Builder()

            okHttpBuilder.addInterceptor(okLogInterceptor)

            val okHttpClient = okHttpBuilder.build()
            Retrofit.Builder()
                .baseUrl("https://docs.google.com/")
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .build().create(APIService::class.java)
        }


    }

}