package com.neppplus.storeorderpractice_20220510

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neppplus.storeorderpractice_20220510.adapters.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    뷰페이저 어댑터를 멤버 변수 생성
    lateinit var mPagerAdapter : MainViewPagerAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    fun setupEvents() {

    }

    fun setValues() {
//        멤버변수로 만들어놓은 어댑터를 실제로 초기화
        mPagerAdapter = MainViewPagerAdapter(supportFragmentManager)
//        xml에 만들어 놓은 뷰페이저 어댑터 연결
        mainViewPager.adapter = mPagerAdapter
        
//        xml에 만들어 놓은 TabLayout에 뷰페이저 연결
        mainTabLayout.setupWithViewPager(mainViewPager)
    }
}