package com.example.apidemoapp.ui.main

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apidemoapp.R
import com.example.apidemoapp.data.UsersListResponseDataItem
import com.example.apidemoapp.ui.userDetails.DetailsActivity

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility == View.VISIBLE
        recyclerView.visibility == View.GONE
        recyclerView.layoutManager = LinearLayoutManager(this)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getUser()!!.observe(this, Observer {
            progressBar.visibility == View.GONE
            recyclerView.visibility == View.VISIBLE
            //val adapter = UserListAdapter(it,UserListAdapter.CallBack)
            val adapter = UserListAdapter(it, object : UserListAdapter.CallBack {
                override fun doClickItem(usersListResponseDataItem: UsersListResponseDataItem) {
//
                    progressBar.visibility == View.VISIBLE
                    doGetUserDetails(usersListResponseDataItem)
                }
            })
            recyclerView.adapter = adapter
        })
    }

    private fun doGetUserDetails(usersListResponseDataItem: UsersListResponseDataItem) {
        mainViewModel.getUserDetailsData()!!.observe(this, Observer { it ->
            progressBar.visibility == View.GONE
            for (item in it) {
                if (usersListResponseDataItem.id == item.id) {
                    val intent = Intent(this, DetailsActivity::class.java)
                    intent.putExtra("object", item)
                    startActivity(intent)
                }
                break
            }

        })
    }
}