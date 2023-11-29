package com.example.apidemoapp.data.userDetails

import java.io.Serializable

data class UserDetailsDataItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
) : Serializable