/*
 * Copyright (c) 2020. Binate Station Private Limited. All rights reserved.
 */

package com.passwordmanager.di
import com.passwordmanager.DashboardActivity
import com.passwordmanager.accountslist.AccountListFragment
import com.passwordmanager.addaccount.AddAccountActivity
import com.passwordmanager.addaccount.userlist.UserListBottomSheetFragment
import com.passwordmanager.shared.di.CoreComponent
import dagger.Component

@PMScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [PMModule::class, PMViewModelModule::class]
)
interface PMComponent {

    fun inject(mainActivity: DashboardActivity)
    fun inject(accountListFragment: AccountListFragment)
    fun inject(addAccountActivity: AddAccountActivity)
    fun inject(userListBottomSheetFragment: UserListBottomSheetFragment)
}
