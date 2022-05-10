package com.neppplus.storeorderpractice_20220510.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.storeorderpractice_20220510.EditNickActivity
import com.neppplus.storeorderpractice_20220510.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment :Fragment() {

//    result Intent를 위한 requestCode 작성
    val REQ_FOR_NICK = 1004

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        changeBtn.setOnClickListener {

//            인텐트 보낼때 startActivityForResult로 requestCode 담아서 보내기
            val myIntent = Intent(requireContext(), EditNickActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_NICK)
        }
    }

//    Intent에서 resultCode를 조건식으로 확인후 requestCode에 따라서 데이터 처리
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQ_FOR_NICK -> {
                    nickTxt.text = data?.getStringExtra("inputNick")
                }
            }
        }
    }
}