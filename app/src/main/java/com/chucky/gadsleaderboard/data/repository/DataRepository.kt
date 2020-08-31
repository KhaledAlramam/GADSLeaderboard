package com.chucky.gadsleaderboard.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chucky.gadsleaderboard.data.model.DataDTO
import com.chucky.gadsleaderboard.data.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository {
    var client = RetrofitClient.webservice


    fun getSkillIqLeaders(): LiveData<List<DataDTO>> {
        val liveData = MutableLiveData<List<DataDTO>>()
        client.getSkillIqLeaders().enqueue(object : Callback<List<DataDTO>> {
            override fun onResponse(call: Call<List<DataDTO>>, response: Response<List<DataDTO>>) {
                if (response.isSuccessful) {
                    liveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<DataDTO>>, t: Throwable) {
                t.printStackTrace()
            }
        })
        return liveData

    }

    fun getHoursLeaders(): LiveData<List<DataDTO>> {
        val liveData = MutableLiveData<List<DataDTO>>()

        client.getHoursLeaders().enqueue(object : Callback<List<DataDTO>> {
            override fun onResponse(call: Call<List<DataDTO>>, response: Response<List<DataDTO>>) {
                if (response.isSuccessful)
                    liveData.value = response.body()
            }

            override fun onFailure(call: Call<List<DataDTO>>, t: Throwable) {
            }
        })
        return liveData
    }
}