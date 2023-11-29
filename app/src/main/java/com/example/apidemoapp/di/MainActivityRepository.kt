package com.example.apidemoapp.di

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.apidemoapp.data.UsersListResponseData
import com.example.apidemoapp.data.userDetails.UserDetailsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {
    val userDetails = MutableLiveData<UserDetailsData>()

    val userListData = MutableLiveData<UsersListResponseData>()

    fun getUserListApiCall(): MutableLiveData<UsersListResponseData> {

        val call = ApiRepository.apiInterface.getUsersListData()

        call.enqueue(object: Callback<UsersListResponseData> {
            override fun onFailure(call: Call<UsersListResponseData>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<UsersListResponseData>,
                response: Response<UsersListResponseData>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())
                val data = response.body()
               // val msg = data!!.message
                userListData.value=response.body()
            }
        })
        return userListData
    }

    fun getUserDetailsData(): MutableLiveData<UserDetailsData> {

        val call = ApiRepository.apiInterface.getUserDataDetails()

        call.enqueue(object: Callback<UserDetailsData> {
            override fun onFailure(call: Call<UserDetailsData>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<UserDetailsData>,
                response: Response<UserDetailsData>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())
                val data = response.body()
                // val msg = data!!.message
                userDetails.value=response.body()
            }
        })
        return userDetails
    }

}