package com.passwordmanager.shared.di

import android.app.Application
import android.content.Context
import com.passwordmanager.shared.repository.CustomerRepository
import com.passwordmanager.shared.repository.network.AdminRetrofitClientInstance
import com.passwordmanager.shared.repository.network.CustomerRetrofitClientInstance
import com.passwordmanager.shared.repository.network.api.CustomerApi
import com.passwordmanager.shared.utils.ResourceProvider
import com.passwordmanager.shared.utils.ResourceProviderImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import javax.inject.Named

@Module
class CoreModule(val application: Application) {

    @Reusable
    @Provides
    fun provideApplication(): Application {
        return application
    }

    @Reusable
    @Provides
    fun provideApplicationContext(): Context {
        return application.applicationContext
    }

    @Reusable
    @Provides
    fun provideResourceProvider(context: Context): ResourceProvider {
        return ResourceProviderImpl(context)
    }

    @Reusable
    @Provides
    fun provideRetrofit(context: Context): Retrofit {
        return CustomerRetrofitClientInstance.getRetrofitInstance(context)
    }

    @Named("admin")
    @Reusable
    @Provides
    fun provideAdminRetrofit(): Retrofit {
        return AdminRetrofitClientInstance.getRetrofitInstance()
    }

    @Reusable
    @Provides
    fun provideCustomerApi(retrofit: Retrofit): CustomerApi {
        return retrofit.create(CustomerApi::class.java)
    }
    @Reusable
    @Provides
    fun provideCustomerRepository(
        customerApi: CustomerApi
    ): CustomerRepository {
        return CustomerRepository(customerApi)
    }
}
