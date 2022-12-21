package com.seohee.everylog_seohee

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.egg.everylogg.R
import com.egg.everylogg.activity.HomeFragment
import com.egg.everylogg.activity.MyPageFragment
import com.egg.everylogg.activity.ReadFragment
import com.egg.everylogg.activity.SearchFragment
import com.egg.everylogg.databinding.ActivityNaviBinding


private const val TAG_SEARCH = "search_fragment"
private const val TAG_HOME = "home_fragment"
private const val TAG_READ = "read_fragment"
private const val TAG_MY_PAGE = "my_page_fragment"

class NaviActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(TAG_HOME, HomeFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.searchFragment -> setFragment(TAG_SEARCH, SearchFragment())
                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                R.id.readFragment-> setFragment(TAG_READ, ReadFragment())
                R.id.myPageFragment-> setFragment(TAG_MY_PAGE, MyPageFragment())
            }
            true
        }
    }
    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val search = manager.findFragmentByTag(TAG_SEARCH)
        val home = manager.findFragmentByTag(TAG_HOME)
        val myPage = manager.findFragmentByTag(TAG_MY_PAGE)
        val read = manager.findFragmentByTag(TAG_READ)

        if (search != null){
            fragTransaction.hide(search)
        }

        if (home != null){
            fragTransaction.hide(home)
        }

        if (myPage != null) {
            fragTransaction.hide(myPage)
        }

        if (read != null) {
            fragTransaction.hide(read)
        }

        if (tag == TAG_SEARCH) {
            if (search!=null){
                fragTransaction.show(search)
            }
        }
        else if (tag == TAG_HOME) {
            if (home != null) {
                fragTransaction.show(home)
            }
        }
        else if (tag == TAG_READ){
            if (read != null){
                fragTransaction.show(read)
            }
        }
        else if (tag == TAG_MY_PAGE){
            if (myPage != null){
                fragTransaction.show(myPage)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}