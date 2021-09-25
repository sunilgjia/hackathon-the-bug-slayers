package com.passwordmanager

import android.app.Application
import com.passwordmanager.shared.di.CoreComponent
import com.passwordmanager.shared.di.CoreComponentProvider
import com.passwordmanager.shared.di.CoreModule
import com.passwordmanager.shared.di.DaggerCoreComponent

class PMApplication : Application(), CoreComponentProvider {

    override fun getCoreComponent(): CoreComponent {
        return DaggerCoreComponent.builder()
            .coreModule(CoreModule(this))
            .build()
    }
}
