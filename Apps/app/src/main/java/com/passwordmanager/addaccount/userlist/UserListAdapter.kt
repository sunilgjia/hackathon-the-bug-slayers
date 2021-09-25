package com.passwordmanager.addaccount.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.passwordmanager.R
import com.passwordmanager.databinding.RowUsersListBinding

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {

    private lateinit var binding : RowUsersListBinding
    inner class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        init {
         binding = RowUsersListBinding.bind(view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_users_list,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }

    override fun getItemCount(): Int =10
}