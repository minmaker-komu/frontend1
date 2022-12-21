package com.egg.everylogg.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.egg.everylogg.adapter.StudyWriteViewPagerAdapter
import com.egg.everylogg.databinding.StudyWritescreenBinding

class StudyWriteActivity : AppCompatActivity() {

    private lateinit var binding: StudyWritescreenBinding

    //image 리스트 선언
    private var imageList = ArrayList<Uri>()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        //binding 초기화
        binding= StudyWritescreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //viewpager 클릭하면 갤러리 열기
        binding.studyWriteViewpager.setOnClickListener{

        }
        //viewpagerAdapter 적용
        binding.studyWriteViewpager.adapter= StudyWriteViewPagerAdapter(this,imageList)
        //binding.studyWriteViewpager.adapter=SWriteViewPagerAdapter(imageList)

        //수평으로 넘기는 것으로 설정
        binding.studyWriteViewpager.orientation= ViewPager2.ORIENTATION_HORIZONTAL

        //circle indicator- setViewPager
        binding.indicator.setViewPager(binding.studyWriteViewpager)


        //study_listscreen activity로 화면 전환
        binding.studyWritesubmitBtn.setOnClickListener {
            startActivity(Intent(this@StudyWriteActivity,StudyListActivity::class.java))
        }
    }
}