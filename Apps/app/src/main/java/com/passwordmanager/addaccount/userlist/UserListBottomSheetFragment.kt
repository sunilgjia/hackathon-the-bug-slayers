package com.passwordmanager.addaccount.userlist

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.passwordmanager.addaccount.AddAccountViewModel
import com.passwordmanager.databinding.FragmentBottomSheetUserListBinding
import com.passwordmanager.di.PMComponent
import com.passwordmanager.utils.showAlert
import javax.inject.Inject

class UserListBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding : FragmentBottomSheetUserListBinding
    private lateinit var adapter : UserListAdapter
    private val viewModel by activityViewModels<AddAccountViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetUserListBinding.inflate(inflater,container,false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUserList()
        setOnClickListeners()
        registerObserver()
        setAdapter()
    }

    private fun registerObserver() {
        viewModel.showProgress.observe(viewLifecycleOwner,{
            it?.let {

            }
        })

        viewModel.userListResponse.observe(viewLifecycleOwner,{
            it?.let {
                adapter.setItems(it)
            }
        })

        viewModel.apiError.observe(viewLifecycleOwner,{
            it?.let { requireContext().showAlert(it
            ) { dialog, which -> }
            }
        })
    }

    private fun setAdapter() {
        adapter = UserListAdapter()
        binding.rvUserList.adapter =adapter
    }

    private fun setOnClickListeners() {
        binding.ivClose.setOnClickListener { dismiss() }
    }
}