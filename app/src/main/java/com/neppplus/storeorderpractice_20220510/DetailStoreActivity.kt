package com.neppplus.storeorderpractice_20220510

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.neppplus.storeorderpractice_20220510.models.StoreData
import kotlinx.android.synthetic.main.activity_detail_store.*

class DetailStoreActivity : AppCompatActivity() {

    lateinit var storeData : StoreData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_store)
        storeData = intent.getSerializableExtra("storeData") as StoreData
        setupEvents()
        setValues()
    }

    fun setupEvents() {}

    fun setValues() {
        nameTxt.text = storeData.name
        Glide.with(this).load(storeData.logoImg).into(logoImg)
        storeRatingBar.rating = storeData.rating.toFloat()
        storeRatingTxt.text = "(${storeData.rating})"
        phoneNumTxt.text = storeData.phoneNum
    }
}