package com.passwordmanager.shared.di

import android.app.Application
import android.content.Context
import com.passwordmanager.shared.repository.CustomerRepository
import com.passwordmanager.shared.repository.local.Session
import com.passwordmanager.shared.repository.network.api.CustomerApi
import com.passwordmanager.shared.utils.ResourceProvider
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class, SessionStorageModule::class])
interface CoreComponent {

    fun provideApplication(): Application

    fun provideApplicationContext(): Context

    fun provideSession(): Session

    fun provideResourceProvider(): ResourceProvider

    fun provideRetrofit(): Retrofit

    @Named("admin")
    fun provideAdminRetrofit(): Retrofit

    fun provideCustomerApi(): CustomerApi

    fun provideCustomerRepository(): CustomerRepository
}
