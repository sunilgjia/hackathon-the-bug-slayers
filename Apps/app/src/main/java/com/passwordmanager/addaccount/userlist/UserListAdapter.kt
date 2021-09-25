package com.passwordmanager.addaccount.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.passwordmanager.R
import com.passwordmanager.databinding.RowUsersListBinding
import com.passwordmanager.shared.repository.models.UserModel

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {

    private lateinit var binding : RowUsersListBinding
    private var userList : List<UserModel?> = listOf()
    inner class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        fun bind(userModel: UserModel?) {
            userModel?.let {
                binding.tvPayment.text = it.name
            }
        }

        init {
         binding = RowUsersListBinding.bind(view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_users_list,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

    fun setItems(it: List<UserModel?>) {
        userList = it
        notifyDataSetChanged()
    }
}