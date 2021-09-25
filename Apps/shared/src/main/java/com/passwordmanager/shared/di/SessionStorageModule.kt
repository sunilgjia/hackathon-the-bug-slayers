package com.passwordmanager.shared.di

import com.passwordmanager.shared.repository.local.Session
import com.passwordmanager.shared.repository.local.SharedPreferencesSessionStorage
import dagger.Binds
import dagger.Module

// Tells Dagger this is a Dagger module
@Module
abstract class SessionStorageModule {

    // Makes Dagger provide SharedPreferencesStorage when a Storage type is requested
    @Binds
    abstract fun provideSession(storage: SharedPreferencesSessionStorage): Session
}
