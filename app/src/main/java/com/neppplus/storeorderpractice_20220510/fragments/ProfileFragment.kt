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
            val myIntent = Intent(requireContext(), EditNickActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_NICK)
        }
    }

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