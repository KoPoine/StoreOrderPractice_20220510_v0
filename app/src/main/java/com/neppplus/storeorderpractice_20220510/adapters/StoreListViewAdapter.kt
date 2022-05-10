package com.neppplus.storeorderpractice_20220510.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.neppplus.storeorderpractice_20220510.R
import com.neppplus.storeorderpractice_20220510.models.StoreData
import com.willy.ratingbar.ScaleRatingBar

class StoreListViewAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<StoreData>
) : ArrayAdapter<StoreData>(mContext, resId, mList) {

//리스트뷰 어댑터 생성후 getView함수 오버라이딩 하여 리스트뷰 각 한칸의 xml 표시 및 한 줄에 데이터 삽입
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = LayoutInflater.from(mContext).inflate(resId, null)
        }
        val row = tempRow!!

        val data = mList[position]

//    CircleImageView의 경우 ImageView를 상속받아 활용하기에 ImageView로 찾아도 가능
//    그러나 ScaleRatingBar는 상속이 BaseRatingBar라는 자체 제작이기 때문에 ScaleRatingBar로 찾아야 한다.
        val logoImg = row.findViewById<ImageView>(R.id.logoImg)
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val ratingBar = row.findViewById<ScaleRatingBar>(R.id.storeRatingBar)

        nameTxt.text = data.name
        Glide.with(mContext).load(data.logoImg).into(logoImg)
        ratingBar.rating = data.rating.toFloat()

        return row
    }

}