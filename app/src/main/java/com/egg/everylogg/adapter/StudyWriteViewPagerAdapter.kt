package com.egg.everylogg.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.egg.everylogg.R

class StudyWriteViewPagerAdapter (private val context: Context, private val items: ArrayList<Uri>): RecyclerView.Adapter<StudyWriteViewPagerAdapter.PagerViewHolder>(){
    inner class PagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val studyImg: ImageView =itemView.findViewById(R.id.studyImg)
        init {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.studywrite_itemlayout,parent,false)
        return PagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.apply {
            Glide.with(context)
                .load(items[position])
                .into(studyImg)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}