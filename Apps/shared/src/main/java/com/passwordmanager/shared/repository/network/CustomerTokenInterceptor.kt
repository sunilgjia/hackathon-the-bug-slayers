package com.passwordmanager.shared.repository.network

import android.accounts.AccountManager
import android.content.Context
import com.passwordmanager.shared.BuildConfig
import com.passwordmanager.shared.utils.Constants
import com.passwordmanager.shared.utils.Constants.GeneralConstants.AUTHORIZATION
import okhttp3.Interceptor
import okhttp3.Response


class CustomerTokenInterceptor(var context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val builder = originalRequest.newBuilder()
            .header("Content-Type", "application/json")

        val accountManager = AccountManager.get(context)
        val account =
            accountManager.getAccountsByType(BuildConfig.ACCOUNT_TYPE)
                .firstOrNull()
        account?.let {
            val token = accountManager.peekAuthToken(
                it,
                Constants.GeneralConstants.BEARER
            )
            if (token?.isNotEmpty() == true) {
                builder.header(AUTHORIZATION, "${Constants.GeneralConstants.BEARER} $token")
            }
        }
        val newRequest = builder.build()
        return chain.proceed(newRequest)
    }
}
