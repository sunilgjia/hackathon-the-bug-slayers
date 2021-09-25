package com.passwordmanager.shared.repository.network

import com.passwordmanager.shared.BuildConfig
import com.passwordmanager.shared.utils.Constants
import com.passwordmanager.shared.utils.Constants.GeneralConstants.AUTHORIZATION
import okhttp3.Interceptor
import okhttp3.Response


class AdminTokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val builder = originalRequest.newBuilder()
            .header("Content-Type", "application/json")

        builder.header(
            AUTHORIZATION,
            "${Constants.GeneralConstants.BEARER} ${BuildConfig.ADMIN_TOKEN}"
        )
        val newRequest = builder.build()
        return chain.proceed(newRequest)
    }
}
