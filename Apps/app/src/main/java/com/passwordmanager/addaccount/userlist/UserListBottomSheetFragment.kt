package com.passwordmanager.addaccount.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.passwordmanager.databinding.FragmentBottomSheetUserListBinding

class UserListBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding : FragmentBottomSheetUserListBinding
    private lateinit var adapter : UserListAdapter

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
        setOnClickListeners()
        setAdapter()
    }

    private fun setAdapter() {
        adapter = UserListAdapter()
        binding.rvUserList.adapter =adapter
    }

    private fun setOnClickListeners() {
        binding.ivClose.setOnClickListener { dismiss() }
    }
}