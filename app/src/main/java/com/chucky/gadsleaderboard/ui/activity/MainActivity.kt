package com.chucky.gadsleaderboard.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.chucky.gadsleaderboard.R
import com.chucky.gadsleaderboard.ui.adapter.TypePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    private lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.viewpager)
        val pagerAdapter = TypePagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)
        submitBtn.setOnClickListener {
            startActivity(Intent(this, SubmitActivity::class.java))
        }
    }


}