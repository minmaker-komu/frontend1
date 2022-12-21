package com.egg.everylogg.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.egg.everylogg.R
import com.egg.everylogg.databinding.ProfileScreenBinding

class ProfileActivity : AppCompatActivity() {  //내정보 페이지 코드
    val PERM_STORAGE = 9
    val PERN_CAMERA = 10

    val REQ_CAMERA = 11

    val binding by lazy{ ProfileScreenBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {

        //액티비티 전환
        val intent = Intent(this, EditProfile::class.java)
        val intent2 = Intent(this, write_scene::class.java)

        var pre_color = "g"
        var percent = 0

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //로그아웃(데이터베이스 필요)
        binding.btnLogout.setOnClickListener {
            startActivityForResult(intent2, 99)
        }

        //프로필 편집 누르면 편집 레이아웃으로 전환
        binding.EditProfile.setOnClickListener {
            startActivityForResult(intent, 99)
        }

        //진행도 표시 코드(데이터베이스랑 연동 필요), 임시로 100으로 설정한거고 글 쓰이는 개수에 따라 setProgress의 percent 달라져야.
        binding.progressBar.setProgress(100)

        //에그 색 바뀌는 코드
        if(binding.progressBar.progress==100){  //progress가 100이면 색 바뀌도록
            binding.progressBar.setProgress(0)  //바뀌고 나면 다시 0으로 리셋(그러므로 이 코드 이후에 다시 진행도가 올라갈 수 있도록 하는 코드 작성 필요)
            when(pre_color) {
                "g" -> {
                    binding.EggImg.setImageResource(R.drawable.yellow_grey)
                    pre_color = "gy"
                }
                "gy"-> {
                    binding.EggImg.setImageResource(R.drawable.light_yellow)
                    pre_color = "ly"
                }
                "ly" -> {
                    binding.EggImg.setImageResource(R.drawable.yellow_egg)
                    pre_color = "y"
                }
                else -> {}
            }
        }


    }

    //프로필 편집한 것 메인 화면에 적용(근데 데이터베이스랑 연동하면 아마 필요없는 코드일 듯..)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== RESULT_OK){
            when(requestCode){
                99->{
                    data?.getStringExtra("returnValue")?.let { message ->
                        binding.UserName.setText(message)
                    }
                }
            }
        }
    }
}