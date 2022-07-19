package com.example.gads_lp1_mlc_vmd_jw

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {


    var viewModelNumber = 0

    fun addNumber() {
        viewModelNumber++
    }
}