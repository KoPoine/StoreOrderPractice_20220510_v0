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

class ChickenStoreFragment :Fragment() {

//    클래스 전역에 사용하기위해 변수로 생성
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
//        storeList에 StoreData 생성하여 넣어주기(강의용 임시 데이터 하드 코딩)
        storeList.add( StoreData("교촌치킨",
            3.8,
            "1577-1991",
            "https://thumb.mt.co.kr/06/2012/01/2012013016268261567_1.jpg") )
        storeList.add( StoreData("네네치킨", 4.5, "1599-4479",
            "https://modo-phinf.pstatic.net/20180122_267/15165994589501NYC2_JPEG/mosa942HN5.jpeg?type=f320_320") )
        storeList.add( StoreData("굽네치킨", 4.2, "1661-9494",
            "https://modo-phinf.pstatic.net/20180614_81/1528938370635K02an_PNG/mosagyYXX5.png?type=f320_320") )
        storeList.add( StoreData("BBQ치킨", 3.3, "1588-9282",
            "https://image.kmib.co.kr/online_image/2018/1118/201811182150_11150924035007_1.jpg") )

//        어댑터 객체화 진행
        mStoreAdapter = StoreListViewAdapter(requireContext(), R.layout.store_list_item, storeList)
//        리스트뷰 변수에 어댑터 넣어주기
        storeListView.adapter = mStoreAdapter

//        리스트뷰 한칸 클릭시의 이벤트 처리
        storeListView.setOnItemClickListener { adapterView, view, i, l ->
            val myIntent = Intent(requireContext(), DetailStoreActivity::class.java)
            myIntent.putExtra("storeData", storeList[i])
            startActivity(myIntent)
        }
    }
}