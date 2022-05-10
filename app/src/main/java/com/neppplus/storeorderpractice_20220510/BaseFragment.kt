package com.neppplus.storeorderpractice_20220510

import androidx.fragment.app.Fragment

abstract class BaseFragment :Fragment() {
    abstract fun setupEvents()
    abstract fun setValues()
}