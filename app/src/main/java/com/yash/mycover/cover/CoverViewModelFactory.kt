package com.yash.mycover.cover

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CoverViewModelFactory(
    private val auth: String,
    private val apiKey: String,
    private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(CoverViewModel::class.java)) {
            return CoverViewModel(auth, apiKey, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")

    }


}
