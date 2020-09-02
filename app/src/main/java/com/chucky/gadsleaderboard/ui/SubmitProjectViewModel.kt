package com.chucky.gadsleaderboard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.chucky.gadsleaderboard.data.repository.DataRepository

class SubmitProjectViewModel : ViewModel() {

    private val dataRepository = DataRepository()

    fun postProject(
        firstName: String,
        lastName: String,
        emailAddress: String,
        link: String
    ): LiveData<Int> {
        return dataRepository.submitProject(firstName, lastName, emailAddress, link)
    }
}