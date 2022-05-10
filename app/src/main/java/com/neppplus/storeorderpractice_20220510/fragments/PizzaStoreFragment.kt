package com.neppplus.storeorderpractice_20220510.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.storeorderpractice_20220510.DetailStoreActivity
import com.neppplus.storeorderpractice_20220510.R
import com.neppplus.storeorderpractice_20220510.adapters.StoreListViewAdapter
import com.neppplus.storeorderpractice_20220510.models.StoreData
import kotlinx.android.synthetic.main.fragment_store.*

class PizzaStoreFragment :Fragment() {

    val storeList = ArrayList<StoreData>()
    lateinit var mStoreAdapter : StoreListViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_store, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        storeList.add( StoreData("피자헛",
            4.5,
            "1588-5588",
            "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg") )
        storeList.add( StoreData("파파존스", 3.8, "1577-8080",
            "http://mblogthumb-phinf.pstatic.net/20160530_116/ppanppane_14646177654870uGy9_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%281%29.png?type=w800") )
        storeList.add( StoreData("도미노피자", 4.2, "1577-3082",
            "https://www.pngplay.com/wp-content/uploads/6/Dominos-Pizza-Logo-Background-PNG-Image.png") )
        storeList.add( StoreData("미스터피자", 3.3, "1577-0077",
            "https://mblogthumb-phinf.pstatic.net/20160530_62/ppanppane_14646177047843NP3E_PNG/%B9%CC%BD%BA%C5%CD%C7%C7%C0%DA_%B7%CE%B0%ED_%283%29.png?type=w800") )

        mStoreAdapter = StoreListViewAdapter(requireContext(), R.layout.store_list_item, storeList)
        storeListView.adapter = mStoreAdapter

        storeListView.setOnItemClickListener { adapterView, view, i, l ->
            val myIntent = Intent(requireContext(), DetailStoreActivity::class.java)
            myIntent.putExtra("storeData", storeList[i])
            startActivity(myIntent)
        }
    }
}