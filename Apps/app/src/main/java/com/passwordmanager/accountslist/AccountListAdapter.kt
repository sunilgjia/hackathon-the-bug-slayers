package com.passwordmanager.accountslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.passwordmanager.R
import com.passwordmanager.databinding.RowAccountsListBinding

class AccountListAdapter : RecyclerView.Adapter<AccountListAdapter.MyViewHolder>() {

    private lateinit var binding: RowAccountsListBinding

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            binding = RowAccountsListBinding.bind(itemView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_accounts_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
       return 10
    }
}