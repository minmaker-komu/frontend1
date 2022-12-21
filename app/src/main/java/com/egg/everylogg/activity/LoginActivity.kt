package com.egg.everylogg.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.egg.everylogg.R
import com.egg.everylogg.databinding.LoginscreenBinding
import com.egg.everylogg.databinding.StudyWritescreenBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginscreenBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        //binding 초기화
        binding= LoginscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}