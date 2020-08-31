package com.chucky.gadsleaderboard.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.chucky.gadsleaderboard.ui.fragment.HoursLeadersFragment
import com.chucky.gadsleaderboard.ui.fragment.SkillIqLeaders

class TypePagerAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            HoursLeadersFragment()
        } else {
            SkillIqLeaders()
        }
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0) {
            "Learning Leaders"
        } else {
            "Skill IQ Leaders"
        }
    }
}