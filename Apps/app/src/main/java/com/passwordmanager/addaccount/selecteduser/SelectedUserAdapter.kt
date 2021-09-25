package com.passwordmanager.addaccount.selecteduser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.passwordmanager.R
import com.passwordmanager.databinding.RowSelectedUsersBinding
import com.passwordmanager.shared.repository.models.UserModel
import java.util.*

class SelectedUserAdapter : RecyclerView.Adapter<SelectedUserAdapter.MyViewHolder>() {

    private lateinit var binding: RowSelectedUsersBinding
    private var selectedList = ArrayList<UserModel?>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(userModel: UserModel?) {
            userModel?.let {
                binding.tvName.text = it.name
                binding.tvEmail.text = it.email
            }
        }

        init {
            binding = RowSelectedUsersBinding.bind(itemView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_selected_users, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(selectedList[position])
    }

    override fun getItemCount(): Int {
        return selectedList.size
    }

    fun setItems(it: ArrayList<UserModel?>) {
        selectedList.clear()
        selectedList = it
        notifyDataSetChanged()
    }

}