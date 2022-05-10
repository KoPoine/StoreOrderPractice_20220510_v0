package com.neppplus.storeorderpractice_20220510.models

import java.io.Serializable

class StoreData(
    val name : String,
    val rating : Double,
    val phoneNum : String,
    val logoImg : String,
) : Serializable {
}