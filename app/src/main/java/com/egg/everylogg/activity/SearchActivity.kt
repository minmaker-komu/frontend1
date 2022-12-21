package com.egg.everylogg.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.egg.everylogg.databinding.SearchscreenBinding

class SearchActivity: AppCompatActivity() {
    private lateinit var binding: SearchscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding 초기화
        binding= SearchscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}