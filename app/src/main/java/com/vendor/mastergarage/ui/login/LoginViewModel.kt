package com.vendor.mastergarage.ui.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vendor.mastergarage.model.CountryCode
import com.vendor.mastergarage.model.OngoingResponseModel
import com.vendor.mastergarage.model.OtpResponseModel
import com.vendor.mastergarage.model.SignUpRespon
import com.vendor.mastergarage.networkcall.Response
import com.vendor.mastergarage.repository.MainRepository
import com.vendor.mastergarage.ui.BaseViewModel
import com.vendor.mastergarage.utlis.NetworkUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    private val repository: MainRepository
) : BaseViewModel(application) {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getCountry()
        }
    }

    private val signinotpLiveData = MutableLiveData<Response<OtpResponseModel>>()


    val signinotpData: LiveData<Response<OtpResponseModel>>
        get() = signinotpLiveData

    fun signinotp(mobileNumber: String, otp: String) = viewModelScope.launch(Dispatchers.IO) {

        try {
            if (NetworkUtil.isInternetAvailable(context)) {

                val result = repository.signInOtp(mobileNumber, "otpVerified", otp)
                if (result.body() != null) {

                    signinotpLiveData.postValue(Response.Success(result.body()))
                } else {

                    signinotpLiveData.postValue(Response.Failure("api error"))
                }
            } else {

                signinotpLiveData.postValue(Response.Failure("No network"))
            }
        } catch (e: Exception) {

            signinotpLiveData.postValue(Response.Failure(e.message.toString()))
        }
    }


    //ongoing start

    private val ongoingLiveData = MutableLiveData<Response<OngoingResponseModel>>()


    val ongoingData: LiveData<Response<OngoingResponseModel>>
        get() = ongoingLiveData


    fun ongoing(vendorId: Int) = viewModelScope.launch(Dispatchers.IO) {

        try {
            if (NetworkUtil.isInternetAvailable(context)) {

                val result = repository.getVendorOngoing(vendorId)
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


//ongoing



    private val signUpLiveData = MutableLiveData<Response<SignUpRespon>>()

    val signUpData : LiveData<Response<SignUpRespon>>
        get() = signUpLiveData

    fun signUp (mobileNumber : String) = viewModelScope.launch(Dispatchers.IO){

        try {
            if (NetworkUtil.isInternetAvailable(context)) {
                val result = repository.signUp(mobileNumber)
                if (result.body() != null) {
                    signUpLiveData.postValue(Response.Success(result.body()))
                } else {
                    signUpLiveData.postValue(Response.Failure("api error"))
                }
            } else {
                signUpLiveData.postValue(Response.Failure("No network"))
            }
        } catch (e: Exception) {
            signUpLiveData.postValue(Response.Failure(e.message.toString()))
        }
    }
//end
    private val countryLiveData = MutableLiveData<Response<CountryCode>>()

    val countrys: LiveData<Response<CountryCode>>
        get() = countryLiveData

    private suspend fun getCountry() {
        try {
            val result = repository.getCountry()
            if (result.body() != null) {
                countryLiveData.postValue(Response.Success(result.body()))
            } else {
                countryLiveData.postValue(Response.Failure("api error"))
            }
        } catch (e: Exception) {
            countryLiveData.postValue(Response.Failure(e.message.toString()))
        }
    }

}