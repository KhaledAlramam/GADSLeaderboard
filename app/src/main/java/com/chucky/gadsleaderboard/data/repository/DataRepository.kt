package com.chucky.gadsleaderboard.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chucky.gadsleaderboard.data.model.DataDTO
import com.chucky.gadsleaderboard.data.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository {
    private var client = RetrofitClient.webservice
    private var client2 = RetrofitClient.webservice2


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

    fun submitProject(
        firstName: String,
        lastName: String,
        emailAddress: String,
        link: String
    ): LiveData<Int> {
        val liveData = MutableLiveData<Int>()
        client2.submitProject(firstName, lastName, emailAddress, link)
            .enqueue(object : Callback<Void> {

                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Log.e("TAG", "onResponse: " + response.code())
                    if (response.isSuccessful) liveData.postValue(1)
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    liveData.postValue(0)
                }

            })
        return liveData
    }
}