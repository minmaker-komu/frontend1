package com.egg.everylogg.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.egg.everylogg.databinding.StudyShowscreenBinding

class StudyShowActivity: AppCompatActivity() {
    private lateinit var binding: StudyShowscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding 초기화
        binding= StudyShowscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}