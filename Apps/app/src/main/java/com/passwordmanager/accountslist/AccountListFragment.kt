package com.passwordmanager.accountslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.passwordmanager.utils.Constants
import com.passwordmanager.databinding.FragmentListBinding
import com.passwordmanager.di.PMComponentProvider
import javax.inject.Inject

class AccountListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var adapter : AccountListAdapter
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var key = arguments?.getString(Constants.Bundle.KEY_TYPE)
        adapter = AccountListAdapter()
        binding.rvAccountList.adapter = adapter
    }

    companion object {
        fun getInstance(type: String): AccountListFragment {
            return AccountListFragment().apply {
                arguments = Bundle().apply {
                    putString(Constants.Bundle.KEY_TYPE,"")
                }
            }
        }
    }
}