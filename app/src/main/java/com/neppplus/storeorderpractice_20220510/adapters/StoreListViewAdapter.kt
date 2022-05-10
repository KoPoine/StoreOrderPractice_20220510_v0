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

class StoreListViewAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<StoreData>
) : ArrayAdapter<StoreData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = LayoutInflater.from(mContext).inflate(resId, null)
        }
        val row = tempRow!!

        val data = mList[position]

        val logoImg = row.findViewById<ImageView>(R.id.logoImg)
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val ratingBar = row.findViewById<RatingBar>(R.id.storeRatingBar)

        nameTxt.text = data.name
        Glide.with(mContext).load(data.logoImg).into(logoImg)
        ratingBar.rating = data.rating.toFloat()

        return row
    }

}