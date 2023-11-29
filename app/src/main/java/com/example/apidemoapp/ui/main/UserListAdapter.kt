package com.example.apidemoapp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apidemoapp.R
import com.example.apidemoapp.data.UsersListResponseData
import com.example.apidemoapp.data.UsersListResponseDataItem

class UserListAdapter(
    private val mList: UsersListResponseData,
    private val  callback: CallBack,
) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

  // lateinit var callback: CallBack
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_list_itemview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = mList[position].name
        holder.tvCName.text = mList[position].company.name
        holder.tvBS.text = mList[position].company.bs
        holder.tvCatchPhrase.text = mList[position].company.catchPhrase
        holder.tvEmail.text = mList[position].email
        holder.itemView.setOnClickListener{
            callback.doClickItem(mList[position])
        }



    }
    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvCName: TextView = itemView.findViewById(R.id.tv_c_name)
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvBS: TextView = itemView.findViewById(R.id.tv_bs)
        val tvCatchPhrase: TextView = itemView.findViewById(R.id.tv_catchPhrase)
        val tvEmail: TextView = itemView.findViewById(R.id.tv_email)
    }

    interface CallBack{
        fun doClickItem(usersListResponseDataItem: UsersListResponseDataItem);
    }
}