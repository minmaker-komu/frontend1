package com.egg.everylogg.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egg.everylogg.databinding.ActivityDiaryReadBinding


class DiaryRead : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding by lazy { ActivityDiaryReadBinding.inflate(layoutInflater) }

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}