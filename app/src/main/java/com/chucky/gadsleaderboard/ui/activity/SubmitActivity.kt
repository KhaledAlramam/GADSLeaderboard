package com.chucky.gadsleaderboard.ui.activity

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.chucky.gadsleaderboard.R
import com.chucky.gadsleaderboard.ui.SubmitProjectViewModel
import com.chucky.gadsleaderboard.util.ext.isTextVerified
import kotlinx.android.synthetic.main.activity_submit.*


class SubmitActivity : AppCompatActivity() {

    private lateinit var viewModel: SubmitProjectViewModel

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
            showConfirmDialog()
        }
    }

    private fun showConfirmDialog() {
        val confirmDialog = Dialog(this, android.R.style.Theme_Dialog)
        confirmDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        confirmDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        confirmDialog.setContentView(R.layout.dialog_submit)

        confirmDialog.findViewById<Button>(R.id.confirmSubmitBtn).setOnClickListener {
            confirmDialog.dismiss()
            doCall()

        }
        confirmDialog.findViewById<ImageView>(R.id.icClose).setOnClickListener {
            confirmDialog.dismiss()
        }
        confirmDialog.show()
        confirmDialog.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun doCall() {
        viewModel.postProject(
            firstNameEt.text.toString(),
            lastNameEt.text.toString(),
            emailEt.text.toString(),
            projectLinkEt.text.toString()
        ).observe(this, {
            if (it == 1) {
                showResultDialog(R.drawable.ic_cloud_done, "Submission successful")
            } else if (it == 0) {
                showResultDialog(R.drawable.ic_warning, "Submission not successful")
            }
        })
    }

    private fun showResultDialog(imgRes: Int, txt: String) {
        val resultDialog = Dialog(this, android.R.style.Theme_Dialog)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        with(resultDialog) {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.dialog_result)
            findViewById<ImageView>(R.id.resultImg).setImageResource(imgRes)
            findViewById<TextView>(R.id.resultTxt).text = txt
        }

        resultDialog.show()
        resultDialog.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }
}