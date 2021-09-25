package com.passwordmanager.accountslist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.passwordmanager.R
import com.passwordmanager.addaccount.AddAccountActivity
import com.passwordmanager.databinding.FragmentListBinding
import com.passwordmanager.di.PMComponentProvider
import com.passwordmanager.shared.repository.models.CredModel
import com.passwordmanager.utils.ClickListener
import com.passwordmanager.utils.Constants
import com.passwordmanager.utils.showAlert
import javax.inject.Inject

class AccountListFragment : Fragment(), ClickListener {
    private lateinit var binding: FragmentListBinding
    private lateinit var adapter: AccountListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: AccountListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as PMComponentProvider).getPMComponent().inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[AccountListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val key = arguments?.getBoolean(Constants.Bundle.KEY_TYPE)
        viewModel.setType(key)
        adapter = AccountListAdapter(this)
        binding.rvAccountList.adapter = adapter
        registerObserver()
    }

    private fun registerObserver() {
        viewModel.credListResponse.observe(viewLifecycleOwner, {
            it?.let {
                adapter.setItems(it)
            }
        })
        viewModel.apiError.observe(viewLifecycleOwner, {
            it?.let {
                requireContext().showAlert(
                    it
                ) { _, _ -> }
            }
        })
        viewModel.noNetwork.observe(viewLifecycleOwner, {
            it?.let {
                requireContext().showAlert(
                    it
                ) { _, _ -> }
            }
        })
    }

    companion object {
        fun getInstance(type: Boolean): AccountListFragment {
            return AccountListFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(Constants.Bundle.KEY_TYPE, type)
                }
            }
        }
    }

    override fun onItemClickListener(item: Any?, view: View) {
        if (view.id == R.id.btnEdit) {
            activity?.let {
                val intent = Intent(activity, AddAccountActivity::class.java)
                intent.putExtra("credId", (item as CredModel).id)
                startActivity(intent)
            }
        }
        if (view.id == R.id.btnDelete) {
            context?.showAlert(
                getString(R.string.delete_confirmation_message)
            ) { dialog, which ->
            }
        }
    }
}