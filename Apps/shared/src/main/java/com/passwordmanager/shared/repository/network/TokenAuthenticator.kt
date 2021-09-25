package com.passwordmanager.shared.repository.network

import android.accounts.Account
import android.accounts.AccountManager
import android.content.Context
import com.passwordmanager.shared.utils.Constants
import com.passwordmanager.shared.utils.Constants.GeneralConstants.TOKEN_URL
import com.google.gson.Gson
import com.passwordmanager.shared.BuildConfig
import com.passwordmanager.shared.BuildConfig.API_VERSION
import okhttp3.Authenticator
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.Route
import java.net.URL


class TokenAuthenticator(val context: Context) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        return refreshToken()?.let {
            response.request.newBuilder()
                .header("Content-Type", "application/json")
                .header(
                    Constants.GeneralConstants.AUTHORIZATION,
                    "${Constants.GeneralConstants.BEARER} $it"
                )
                .build()
        }
    }

    private fun refreshToken(): String? {
        val accountManager = AccountManager.get(context)
        val account =
            accountManager.getAccountsByType(BuildConfig.ACCOUNT_TYPE).firstOrNull()
        return account?.let {
            val refreshUrl = URL(BuildConfig.BASE_URL + API_VERSION + TOKEN_URL)
            val requestBody: RequestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("username", account.name)
                .addFormDataPart("password", accountManager.getPassword(account))
                .build()
            val request: Request = Request.Builder()
                .url(refreshUrl)
                .post(requestBody)
                .build()
            val client = OkHttpClient()
            val response = client.newCall(request).execute()
            if (response.code == 200) {
                val gson = Gson()
                val token = gson.fromJson(response.body?.string(), String::class.java)
                updateAccount(
                    account,
                    token
                )
                token
            } else {
                null
            }
        }
    }

    /**
     * Create account to store and secure user information
     * Android custom account type information like account label, account type, icon and other information is defined in xml file
     * This information is displayed on accounts screen, preference screen and is used by account manager to perform account operations.
     *
     * @param account Account to update
     * @param authToken It is used to authorise the user
     */
    private fun updateAccount(
        account: Account?,
        authToken: String?
    ) {
        val am = AccountManager.get(context)
        am.setAuthToken(account, Constants.GeneralConstants.BEARER, authToken)
    }

}
