package com.passwordmanager.addaccount

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.passwordmanager.R
import com.passwordmanager.addaccount.selecteduser.SelectedUserAdapter
import com.passwordmanager.addaccount.userlist.UserListBottomSheetFragment
import com.passwordmanager.databinding.FragmentAddAccountBinding
import com.passwordmanager.di.PMComponentProvider
import com.passwordmanager.shared.repository.models.UserModel
import com.passwordmanager.utils.showToast
import javax.inject.Inject

class AddAccountActivity : AppCompatActivity() {
    private lateinit var binding: FragmentAddAccountBinding
    private lateinit var adapter: SelectedUserAdapter
    private lateinit var viewModel: AddAccountViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var selectedUserList = ArrayList<UserModel?>()

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
            val userListBottomSheetFragment = UserListBottomSheetFragment()
            userListBottomSheetFragment.setListener {
                selectedUserList = it
                adapter.setItems(it)
            }
            userListBottomSheetFragment.show(supportFragmentManager, "User List")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.add_account, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.done ->{
                isDataValid()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun isDataValid() {
        if (binding.edtName.text.toString().trim().isEmpty()){
            showToast(getString(R.string.please_enter_name))
        } else if (binding.edtEmail.text.toString().trim().isEmpty()){
            showToast(getString(R.string.please_enter_email))
        } else if (binding.edtPassword.text.toString().trim().isEmpty()){
            showToast(getString(R.string.please_enter_password))
        } else if (binding.edtDescription.text.toString().trim().isEmpty()){
            showToast(getString(R.string.please_enter_description))
        } else{
            viewModel.addAccount(binding.edtName.text.toString(),
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString(),
                binding.edtDescription.text.toString(),
                selectedUserList
            )
        }
    }

    private fun initAdapter() {
        adapter = SelectedUserAdapter()
        binding.rvSelectedUser.adapter = adapter
    }
}