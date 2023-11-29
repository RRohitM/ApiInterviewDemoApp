package com.example.apidemoapp.ui.userDetails

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apidemoapp.R
import com.example.apidemoapp.data.userDetails.UserDetailsData
import com.example.apidemoapp.data.userDetails.UserDetailsDataItem

class DetailsActivity : AppCompatActivity() {
    private lateinit var tvTitle:TextView
    private lateinit var tvSubTitle:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        tvTitle = findViewById<TextView>(R.id.tv_title)
        tvSubTitle = findViewById<TextView>(R.id.tv_subtitle)

        val data=intent.getSerializableExtra("object")as UserDetailsDataItem
        tvTitle.text=data.title
        //tvSubTitle.text=data.body
        //val object = getI.getSerializableExtra("object") as UserDetailsData

    }
}