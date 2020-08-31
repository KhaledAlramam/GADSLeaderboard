package com.chucky.gadsleaderboard.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.chucky.gadsleaderboard.R
import com.chucky.gadsleaderboard.ui.fragment.HoursLeadersFragment
import com.chucky.gadsleaderboard.ui.fragment.SkillIqLeaders
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, HoursLeadersFragment())
            .commit()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tabLayout.selectedTabPosition == 0) {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, HoursLeadersFragment())
                        .commit()
                } else if (tabLayout.selectedTabPosition == 1) {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fragmentContainer,
                            SkillIqLeaders()
                        )
                        .commit()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
        submitBtn.setOnClickListener {
            startActivity(Intent(this, SubmitActivity::class.java))
        }
    }


}