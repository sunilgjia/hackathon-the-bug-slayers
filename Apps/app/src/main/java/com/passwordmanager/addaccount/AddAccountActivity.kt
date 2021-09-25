package com.passwordmanager.addaccount

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.passwordmanager.R
import com.passwordmanager.addaccount.selecteduser.SelectedUserAdapter
import com.passwordmanager.addaccount.userlist.UserListBottomSheetFragment
import com.passwordmanager.databinding.FragmentAddAccountBinding

class AddAccountActivity : AppCompatActivity() {
    private lateinit var binding : FragmentAddAccountBinding
    private lateinit var adapter : SelectedUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_add_account)
        setOnClickListener()
        initAdapter()
    }

    private fun setOnClickListener() {
        binding.btnShareUser.setOnClickListener {
            UserListBottomSheetFragment().show(supportFragmentManager,"User List")
        }
    }

    private fun initAdapter() {
        adapter = SelectedUserAdapter()
        binding.rvSelectedUser.adapter = adapter
    }
}