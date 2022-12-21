package com.egg.everylogg.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.egg.everylogg.databinding.ActivityEditProfileBinding

class EditProfile : AppCompatActivity() {

    val REQ_GALLERY = 12

    val binding by lazy { ActivityEditProfileBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //프로필사진 변경 클릭하는 경우
        binding.editProfileImg.setOnClickListener {
            openGallery()
        }

        //저장 버튼 누르는 경우 정보 MAIN으로 넘기도록 하는 코드인데 이것도 데이터베이스 연동하면 필요 없는 코드일 듯
        //저장 누르면 정보가 데이터베이스로 가고 그 데이터베이스에서 정보 받아서 main에 적용되도록 해야 함
        binding.EditProfileBtnSave.setOnClickListener {
            val returnIntent = Intent()
            val name = binding.editPersonName.text.toString()
            returnIntent.putExtra("returnValue", name)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }

    //갤러리 호출 코드(창 띄우는 코드)
    fun openGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        startActivityForResult(intent, REQ_GALLERY)
    }

    //갤러리에서 선택 후 호출됨(edit 화면 프사 바뀜)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== RESULT_OK){
            when(requestCode){
                REQ_GALLERY->{
                    data?.data?.let { uri->
                        binding.imageView3.setImageURI(uri)
                    }
                }
           }
        }
    }
}