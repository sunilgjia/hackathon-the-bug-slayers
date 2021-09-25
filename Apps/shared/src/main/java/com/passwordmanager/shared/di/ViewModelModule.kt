package com.passwordmanager.shared.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.passwordmanager.shared.SharedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelMapKey(SharedViewModel::class)
    abstract fun bindSharedViewModel(sharedViewModel: SharedViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: WafiViewModelFactory): ViewModelProvider.Factory

}
