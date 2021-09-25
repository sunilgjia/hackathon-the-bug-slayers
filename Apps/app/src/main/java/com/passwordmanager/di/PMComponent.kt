/*
 * Copyright (c) 2020. Binate Station Private Limited. All rights reserved.
 */

package com.passwordmanager.di
import com.passwordmanager.MainActivity
import com.passwordmanager.shared.di.CoreComponent
import dagger.Component

@PMScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [PMModule::class, PMViewModelModule::class]
)
interface PMComponent {

    fun inject(mainActivity: MainActivity)

}
