package com.egg.everylogg.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egg.everylogg.databinding.ActivityDiaryWriteBinding

class DiaryWrite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding by lazy { ActivityDiaryWriteBinding.inflate(layoutInflater) }

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}