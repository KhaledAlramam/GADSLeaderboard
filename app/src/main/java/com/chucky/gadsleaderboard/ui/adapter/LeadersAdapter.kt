package com.chucky.gadsleaderboard.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chucky.gadsleaderboard.R
import com.chucky.gadsleaderboard.data.model.DataDTO
import com.chucky.gadsleaderboard.ui.fragment.HoursLeadersFragment

class LeadersAdapter(var context: Context, var mData: List<DataDTO>, val type: String) :
    RecyclerView.Adapter<LeadersAdapter.LeaderViewHolder>() {


    class LeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTv: TextView = itemView.findViewById(R.id.nameTv)
        val badgeImg: ImageView = itemView.findViewById(R.id.badgeImg)
        val scoreTv: TextView = itemView.findViewById(R.id.scoreTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderViewHolder {
        return LeaderViewHolder(
            LayoutInflater
                .from(context)
                .inflate(R.layout.rv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: LeaderViewHolder, position: Int) {
        if (type == HoursLeadersFragment.HOURS_TYPE) {
            holder.badgeImg.setImageResource(R.drawable.learner_badge)
            holder.nameTv.text = mData[position].name
            holder.scoreTv.text = context.getString(
                R.string.hours_text,
                mData[position].hours.toString(),
                mData[position].country
            )
        } else {
            holder.badgeImg.setImageResource(R.drawable.skill_iq_badge)
            holder.nameTv.text = mData[position].name
            holder.scoreTv.text = context.getString(
                R.string.skill_iq_text,
                mData[position].score.toString(),
                mData[position].country
            )
        }

    }

    fun setmData(mData: List<DataDTO>) {
        this.mData = mData
    }

    override fun getItemCount(): Int = mData.size

}