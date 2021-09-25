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
import com.passwordmanager.shared.repository.models.UserModel
import com.passwordmanager.utils.ClickListener
import com.passwordmanager.utils.showAlert
import javax.inject.Inject

class UserListBottomSheetFragment : BottomSheetDialogFragment(), ClickListener {

    private lateinit var binding : FragmentBottomSheetUserListBinding
    private lateinit var adapter : UserListAdapter
    private val viewModel by activityViewModels<AddAccountViewModel>()
    private var listner: ((ArrayList<UserModel?>) -> Unit)? = null
    private var selectedUserList = ArrayList<UserModel?>()

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
        adapter = UserListAdapter(this)
        binding.rvUserList.adapter =adapter
    }

    private fun setOnClickListeners() {
        binding.ivClose.setOnClickListener { dismiss() }

        binding.btnDone.setOnClickListener {
            listner?.invoke(selectedUserList)
            dismiss()
        }
    }

    fun setListener(listener: (ArrayList<UserModel?>) -> Unit){
        listner = listener
    }

    override fun onDetach() {
        super.onDetach()
        selectedUserList.clear()
    }
    override fun onItemClickListener(item: Any?, view: View) {
        if (item is UserModel?){
            val list = selectedUserList.find { it?.email == item?.email }
            if (list!=null){
                selectedUserList.remove(item)
            }else{
                selectedUserList.add(item)
            }
        }
    }
}