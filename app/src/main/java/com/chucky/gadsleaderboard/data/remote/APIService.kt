package com.chucky.gadsleaderboard.data.remote

import com.chucky.gadsleaderboard.data.model.DataDTO
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {
    @GET("/api/skilliq")
    fun getSkillIqLeaders(): Call<List<DataDTO>>

    @GET("/api/hours")
    fun getHoursLeaders(): Call<List<DataDTO>>

    @POST("/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    fun submitProject(
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.1824927963") emailAddress: String,
        @Field("entry.284483984") projectLink: String
    ): Call<Void>

}