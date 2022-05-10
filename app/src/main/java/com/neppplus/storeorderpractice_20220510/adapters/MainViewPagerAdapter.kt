package com.neppplus.storeorderpractice_20220510.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.neppplus.storeorderpractice_20220510.fragments.PizzaStoreFragment
import com.neppplus.storeorderpractice_20220510.fragments.ProfileFragment

class MainViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
//    뷰페이저가 가지고 있을 프래그먼트의 숫자
    override fun getCount() = 2

//    각 페이지가 보여줄 프래그먼트
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PizzaStoreFragment()
            else -> ProfileFragment()
        }
    }

//    TabLayout에 보여줄 페이지 제목
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "피자 주문"
            else -> "내 정보 설정"
        }
    }
}