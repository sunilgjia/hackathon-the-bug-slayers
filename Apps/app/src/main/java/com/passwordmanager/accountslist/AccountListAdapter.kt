package com.passwordmanager.accountslist

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.passwordmanager.R
import com.passwordmanager.databinding.RowAccountsListBinding
import com.passwordmanager.shared.repository.models.CredModel
import com.passwordmanager.utils.ClickListener
import com.passwordmanager.utils.showAlert
import com.passwordmanager.utils.showToast

class AccountListAdapter(private val listener : ClickListener) : RecyclerView.Adapter<AccountListAdapter.MyViewHolder>() {

    private lateinit var binding: RowAccountsListBinding
    private var credList: List<CredModel?> = listOf()

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
        val cred = credList[position]

        binding.btnCopyPassword.setOnClickListener {
            copyToClipBoard(holder.itemView.context, cred?.password)
        }

        binding.btnEdit.setOnClickListener {
            listener.onItemClickListener(cred, view = it)
        }
        binding.btnDelete.setOnClickListener {
            listener.onItemClickListener(cred, view = it)
        }

        cred?.let {
            binding.tvName.text = it.name
            binding.tvEmail.text = it.userName

            binding.btnEdit.visibility = if(it.canEdit) View.VISIBLE else View.GONE
            binding.btnDelete.visibility = if(it.canDelete) View.VISIBLE else View.GONE
            binding.btnCopyPassword.visibility = if(it.canView) View.VISIBLE else View.GONE
        }
    }

    private fun copyToClipBoard(context: Context, message: String?) {
        val clipBoard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("label", message)
        clipBoard.setPrimaryClip(clipData)
        context.showToast(context.getString(R.string.password_copied))
    }

    override fun getItemCount(): Int {
        return credList.size
    }

    fun setItems(credModel: List<CredModel?>) {
        credList = credModel
        notifyDataSetChanged()
    }
}