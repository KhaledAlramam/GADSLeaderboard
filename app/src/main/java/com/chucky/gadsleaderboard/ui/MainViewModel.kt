package com.chucky.gadsleaderboard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.chucky.gadsleaderboard.data.model.DataDTO
import com.chucky.gadsleaderboard.data.repository.DataRepository

class MainViewModel : ViewModel() {

    private val repository: DataRepository = DataRepository()

    fun getHoursLeader(): LiveData<List<DataDTO>> {
        return repository.getHoursLeaders()
    }

    fun getSkillIqLeaders(): LiveData<List<DataDTO>> {
        return repository.getSkillIqLeaders()
    }
}