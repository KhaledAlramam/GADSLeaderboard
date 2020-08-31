package com.chucky.gadsleaderboard.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.chucky.gadsleaderboard.R
import com.chucky.gadsleaderboard.ui.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        bindData()
        submitBtn.setOnClickListener {
            startActivity(Intent(this, SubmitActivity::class.java))
        }
    }

    private fun bindData() {
        Log.e("TAG", "bindData: ")

        mainViewModel.getHoursLeader().observe(this, Observer {
            Log.e("TAG", "bindData: " + it)
        })
    }
}