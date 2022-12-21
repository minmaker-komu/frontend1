package com.egg.everylogg.activity

import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.egg.everylogg.R
import com.egg.everylogg.adapter.ListViewAdapter

class StudyListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.study_listscreen)

        val listview: ListView
        val adapter: ListViewAdapter

        adapter= ListViewAdapter()

        listview=findViewById<View>(R.id.studylist) as ListView
        listview.adapter=adapter

        adapter.addItem(
            ContextCompat.getDrawable(this,R.drawable.listviewtestimg1)!!,
            "test1","testtag1")
        adapter.addItem(
            ContextCompat.getDrawable(this,R.drawable.listviewtestimg2)!!,
            "test2","testtag2")
        adapter.addItem(
            ContextCompat.getDrawable(this,R.drawable.listviewtestimg3)!!,
            "test3","testtag3")
    }
}