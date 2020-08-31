package com.chucky.gadsleaderboard.data.remote

import com.chucky.gadsleaderboard.data.model.DataDTO
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("/api/skilliq")
    fun getSkillIqLeaders(): Call<List<DataDTO>>

    @GET("/api/hours")
    fun getHoursLeaders(): Call<List<DataDTO>>

//    companion object {
//        fun create(): APIService {
//
//            val retrofit = Retrofit.Builder()
//                .addConverterFactory(
//                    GsonConverterFactory.create())
//                .baseUrl("https://gadsapi.herokuapp.com/")
//                .build()
//
//            return retrofit.create(APIService::class.java)
//        }
//    }
}