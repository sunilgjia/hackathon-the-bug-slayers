package com.passwordmanager.shared.repository.network
import com.google.gson.GsonBuilder
import com.passwordmanager.shared.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object AdminRetrofitClientInstance {

    private var retrofit: Retrofit? = null

    fun getRetrofitInstance(): Retrofit {
        return retrofit ?: synchronized(this) {
            retrofit ?: buildRetrofitApi().also { retrofit = it }
        }
    }

    private fun buildRetrofitApi(): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create()
        val tokenInterceptor = AdminTokenInterceptor()

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(tokenInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL + BuildConfig.API_VERSION)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}
