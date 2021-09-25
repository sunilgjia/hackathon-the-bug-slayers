package com.passwordmanager.accountslist

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.passwordmanager.R
import com.passwordmanager.databinding.RowAccountsListBinding
import com.passwordmanager.utils.showAlert

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
        binding.btnCopyPassword.setOnClickListener {
            copyToClipBoard(holder.itemView.context,"")
        }

        binding.btnDelete.setOnClickListener {
            it?.context?.getString(R.string.delete_confirmation_message).orEmpty()?.let { it1 ->
                it?.context?.showAlert(
                    it1
                ) { dialog, which ->

                }
            }
        }

    }
    private fun copyToClipBoard(context :Context,message: String) {
        val clipBoard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("label", message)
        clipBoard.setPrimaryClip(clipData)
    }

    override fun getItemCount(): Int {
       return 10
    }
}