package com.instance.gravy.viewmodel

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class GravyMainViewModel @Inject constructor() : ViewModel() {
    fun getData(): String = "Nandakishor"
}