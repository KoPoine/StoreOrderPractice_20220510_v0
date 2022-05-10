package com.neppplus.storeorderpractice_20220510

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
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

    fun setupEvents() {
        callBtn.setOnClickListener {
            val pl = object : PermissionListener {
                override fun onPermissionGranted() {
                    val myUri = Uri.parse("tel:${storeData.phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(this@DetailStoreActivity, "권한이 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            TedPermission.create()
                .setPermissionListener(pl)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }
    }

    fun setValues() {
        nameTxt.text = storeData.name
        Glide.with(this).load(storeData.logoImg).into(logoImg)
        storeRatingBar.rating = storeData.rating.toFloat()
        storeRatingTxt.text = "(${storeData.rating})"
        phoneNumTxt.text = storeData.phoneNum
    }
}