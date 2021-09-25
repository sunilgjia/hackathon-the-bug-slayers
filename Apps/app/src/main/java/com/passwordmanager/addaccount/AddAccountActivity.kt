package com.passwordmanager.addaccount

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.passwordmanager.R
import com.passwordmanager.addaccount.selecteduser.SelectedUserAdapter
import com.passwordmanager.addaccount.userlist.UserListBottomSheetFragment
import com.passwordmanager.databinding.FragmentAddAccountBinding
import com.passwordmanager.di.PMComponentProvider
import javax.inject.Inject

class AddAccountActivity : AppCompatActivity() {
    private lateinit var binding: FragmentAddAccountBinding
    private lateinit var adapter: SelectedUserAdapter
    private lateinit var viewModel: AddAccountViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as PMComponentProvider).getPMComponent().inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_add_account)
        viewModel = ViewModelProvider(this, viewModelFactory)[AddAccountViewModel::class.java]
        setOnClickListener()
        initAdapter()
    }

    private fun setOnClickListener() {
        binding.btnShareUser.setOnClickListener {
            UserListBottomSheetFragment().show(supportFragmentManager, "User List")
        }
    }

    private fun initAdapter() {
        adapter = SelectedUserAdapter()
        binding.rvSelectedUser.adapter = adapter
    }
}