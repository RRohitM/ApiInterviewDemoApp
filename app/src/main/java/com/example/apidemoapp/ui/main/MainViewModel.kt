package com.example.apidemoapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apidemoapp.data.UsersListResponseData
import com.example.apidemoapp.data.userDetails.UserDetailsData
import com.example.apidemoapp.di.MainActivityRepository

class MainViewModel : ViewModel() {

    var userListApi: MutableLiveData<UsersListResponseData>? = null
    var userDetails: MutableLiveData<UserDetailsData>? = null

    fun getUser() : MutableLiveData<UsersListResponseData>? {
        userListApi = MainActivityRepository.getUserListApiCall()
        return userListApi
    }


    fun getUserDetailsData() : MutableLiveData<UserDetailsData>? {
        userDetails = MainActivityRepository.getUserDetailsData()
        return userDetails
    }

}