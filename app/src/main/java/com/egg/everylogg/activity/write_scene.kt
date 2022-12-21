package com.egg.everylogg.activity

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.egg.everylogg.databinding.ActivityWriteSceneBinding
import java.util.*


class write_scene : AppCompatActivity() {

    val REQ_GALLERY = 12

    val binding by lazy { ActivityWriteSceneBinding.inflate(layoutInflater) }

    var arrayList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //완료 버튼 누르면 일단 해시태그만 전달되도록 함
        //해시태그를 데이터베이스에 저장하기 위해 가져오는 과정에서 중복되는 문제 발생: 제대로 동작하는지 알아보기 위해 ReviewContent에 임시로 써서 확인함
        // 예를 들어 #아이하면 아이가 들어옴. 그리고 그 뒤에 #버튼하면 아이 아이 버튼으로 들어옴/ []가 자꾸 같이 껴있음:stringTokenizer 특?
        binding.reviewWritesubmitBtn.setOnClickListener {
            val st = StringTokenizer(binding.ReviewHashTagEditText.text.toString(),"#")
            var j=st.countTokens()
            for(i in 1..j){
                arrayList.add(st.nextToken().toString()) //arrayList에 #을 기준으로 해시태그 나눠서 전달
            }
            binding.editTextReviewContent.setText(arrayList.toString())//제대로 동작하는지 알아보기 위해 ReviewContent에 임시로 써서 확인함
        }

        //리뷰 사진 넣는 경우
        binding.ReviewImageView.setOnClickListener {
            openGallery()
        }

    }
    //갤러리 호출 코드(창 띄우는 코드)
    fun openGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        startActivityForResult(intent, REQ_GALLERY)
    }

    //갤러리에서 선택 후 호출됨(글쓰기에 있는 리뷰사진 바뀜)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== RESULT_OK){
            when(requestCode){
                REQ_GALLERY->{
                    data?.data?.let { uri->
                        binding.ReviewImageView.setImageURI(uri)
                    }
                }
            }
        }
    }
}