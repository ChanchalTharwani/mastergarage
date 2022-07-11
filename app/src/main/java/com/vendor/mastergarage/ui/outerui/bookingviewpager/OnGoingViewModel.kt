package com.vendor.mastergarage.ui.outerui.bookingviewpager

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vendor.mastergarage.model.*
import com.vendor.mastergarage.networkcall.Response
import com.vendor.mastergarage.repository.MainRepository
import com.vendor.mastergarage.ui.BaseViewModel
import com.vendor.mastergarage.utlis.NetworkUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnGoingViewModel @Inject constructor(
    application: Application,
    private val repository: MainRepository
) : BaseViewModel(application) {

    private val ongoingLiveData = MutableLiveData<Response<OnGoingData>>()

    val onGoing: LiveData<Response<OnGoingData>>
        get() = ongoingLiveData

    private fun getStoredOutletObject(): OutletsItem? {
        return repository.getStoredOutletObject()
    }

    init {
        getStoredOutletObject()?.let { it.outletId?.let { it1 -> getOnGoing(it1) } }
    }

    private fun getOnGoing(outletId: Int) = viewModelScope.launch(Dispatchers.IO) {
        try {
            if (NetworkUtil.isInternetAvailable(context)) {
                ongoingLiveData.postValue(Response.Loading())
                val result = repository.getOnGoing(outletId)
                if (result.body() != null) {
                    ongoingLiveData.postValue(Response.Success(result.body()))
                } else {
                    ongoingLiveData.postValue(Response.Failure("api error"))
                }
            } else {
                ongoingLiveData.postValue(Response.Failure("No network"))
            }
        } catch (e: Exception) {
            ongoingLiveData.postValue(Response.Failure(e.message.toString()))
        }
    }



    fun loadUi() {
        getStoredOutletObject()?.let { it.outletId?.let { it1 -> getOnGoing(it1) } }
    }
}