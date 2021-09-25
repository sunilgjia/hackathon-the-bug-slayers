package com.passwordmanager

import android.app.Application
import com.passwordmanager.di.DaggerPMComponent
import com.passwordmanager.di.PMComponent
import com.passwordmanager.di.PMComponentProvider
import com.passwordmanager.shared.di.CoreComponent
import com.passwordmanager.shared.di.CoreComponentProvider
import com.passwordmanager.shared.di.CoreModule
import com.passwordmanager.shared.di.DaggerCoreComponent

class PMApplication : Application(), CoreComponentProvider, PMComponentProvider {

    override fun getCoreComponent(): CoreComponent {
        return DaggerCoreComponent.builder()
            .coreModule(CoreModule(this))
            .build()
    }

    override fun getPMComponent(): PMComponent {
        return DaggerPMComponent.builder()
            .coreComponent(getCoreComponent())
            .build()

    }
}
