package com.neppplus.storeorderpractice_20220510

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_nick.*

class EditNickActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick)
        setupEvents()
        setValues()
    }

    fun setupEvents(){
        changeBtn.setOnClickListener {
            val inputNick = inputNickEdt.text.toString()
            if (inputNick.isBlank()) {
                Toast.makeText(this, "올바른 닉네임을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val resultIntent = Intent()
            resultIntent.putExtra("inputNick", inputNick)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    fun setValues() {}
}