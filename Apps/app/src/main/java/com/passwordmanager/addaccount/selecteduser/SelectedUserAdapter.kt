package com.passwordmanager.addaccount.selecteduser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.passwordmanager.R
import com.passwordmanager.databinding.RowSelectedUsersBinding

class SelectedUserAdapter : RecyclerView.Adapter<SelectedUserAdapter.MyViewHolder>() {

    private lateinit var binding : RowSelectedUsersBinding
    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        init {
            binding = RowSelectedUsersBinding.bind(itemView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_selected_users,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }

}