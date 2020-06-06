package com.yash.mycover.cover

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yash.mycover.network.CoverApi
import com.yash.mycover.network.CoverJob
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

enum class CoverApiStatus { LOADING, ERROR, DONE }


class CoverViewModel(val auth: String, val apiKey: String, app: Application) : ViewModel() {

    private val _coverApiStatus = MutableLiveData<CoverApiStatus>()

    val coverApiStatus: LiveData<CoverApiStatus>
        get() = _coverApiStatus

    private val _coverProperty = MutableLiveData<CoverJob>()

    val coverProperty: LiveData<CoverJob>
        get() = _coverProperty

    private val _coverJobDetail = MutableLiveData<CoverJob.CoverJobDetail>()

    val coverJobDetail: LiveData<CoverJob.CoverJobDetail>
        get() = _coverJobDetail

    /*private val _coverDetails = MutableLiveData<List<CoverJobDetail>>()

    val coverDetails: LiveData<List<CoverJobDetail>>
        get() = _coverDetails*/


    private val viewModelJob = Job()


    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {

        getCoverJobProperty()


    }

    private fun getCoverJobProperty() {

        uiScope.launch {

            var getPropertyDeferred =
                CoverApi.retrofitService.getCoverJobDetails(auth, apiKey)


            try {

//                _coverApiStatus.value = CoverApiStatus.LOADING

                val coverProperty = getPropertyDeferred.await()
//                _coverApiStatus.value = CoverApiStatus.DONE

                _coverProperty.value = coverProperty


            } catch (e: Exception) {
                e.printStackTrace()
//                _coverApiStatus.value = CoverApiStatus.ERROR
                _coverProperty.value = null


            }

        }

    }


    fun displayCoverJobDetails(coverJobDetail: CoverJob.CoverJobDetail) {

        _coverJobDetail.value = coverJobDetail

    }


}