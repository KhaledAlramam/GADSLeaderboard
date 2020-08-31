package com.chucky.gadsleaderboard.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chucky.gadsleaderboard.R
import com.chucky.gadsleaderboard.ui.MainViewModel
import com.chucky.gadsleaderboard.ui.adapter.LeadersAdapter


class SkillIqLeaders : Fragment() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val recyclerView = view.findViewById<RecyclerView>(R.id.hoursRv)
        val adapter = LeadersAdapter(context!!, emptyList(), SKILL_IQ_TYPE)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        mainViewModel.getSkillIqLeaders().observe(this, {
            adapter.setmData(it)
            adapter.notifyDataSetChanged()
        })
        return view
    }

    companion object {
        const val SKILL_IQ_TYPE = "skillIq"
    }
}