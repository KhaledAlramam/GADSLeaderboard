package com.chucky.gadsleaderboard.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.chucky.gadsleaderboard.R
import com.chucky.gadsleaderboard.ui.SubmitProjectViewModel
import com.chucky.gadsleaderboard.util.ext.isTextVerified
import kotlinx.android.synthetic.main.activity_submit.*


class SubmitActivity : AppCompatActivity() {

    lateinit var viewModel: SubmitProjectViewModel
    private val TAG = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)
        val toolbar: Toolbar = findViewById(R.id.toolbar_top)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        viewModel = ViewModelProviders.of(this).get(SubmitProjectViewModel::class.java)

        submitProjectBtn.setOnClickListener {
            if (!firstNameEt.isTextVerified()) {
                Toast.makeText(this, "Please, Enter first name.", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            } else if (!lastNameEt.isTextVerified()) {
                Toast.makeText(this, "Please, Enter last name.", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            } else if (!emailEt.isTextVerified()) {
                Toast.makeText(this, "Please, Enter Email.", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            } else if (!projectLinkEt.isTextVerified()) {
                Toast.makeText(this, "Please, Enter project link.", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            Log.e(TAG, "onCreate: ")

            viewModel.postProject(
                firstNameEt.text.toString(),
                lastNameEt.text.toString(),
                emailEt.text.toString(),
                projectLinkEt.text.toString()
            ).observe(this, Observer {
                if (it == 1) {
                    Log.e(TAG, "onCreate: success")
                } else if (it == 0) {
                    Log.e(TAG, "onCreate: Fail")
                }
            })
        }
    }
}