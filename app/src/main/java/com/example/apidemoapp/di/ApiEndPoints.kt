package com.example.apidemoapp.di

import com.example.apidemoapp.data.UsersListResponseData
import com.example.apidemoapp.data.userDetails.UserDetailsData
import com.example.apidemoapp.data.userDetails.UserDetailsDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoints {
    @GET("users")
    fun getUsersListData() : Call<UsersListResponseData>

    @GET("posts")
    fun getUserDataDetails() : Call<UserDetailsData>
}