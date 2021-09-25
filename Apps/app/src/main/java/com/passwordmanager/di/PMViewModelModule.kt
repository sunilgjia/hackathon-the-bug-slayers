/*
 * Copyright (c) 2020. Binate Station Private Limited. All rights reserved.
 */

package com.passwordmanager.di

import androidx.lifecycle.ViewModel
import com.passwordmanager.accountslist.AccountListViewModel
import com.passwordmanager.addaccount.AddAccountViewModel
import com.passwordmanager.shared.di.ViewModelMapKey
import com.passwordmanager.shared.di.ViewModelModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PMViewModelModule : ViewModelModule(){

    @Binds
    @IntoMap
    @ViewModelMapKey(AccountListViewModel::class)
    abstract fun bindAccountListViewModel(viewModel: AccountListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelMapKey(AddAccountViewModel::class)
    abstract fun bindAddAccountViewModel(viewModel: AddAccountViewModel): ViewModel
}
