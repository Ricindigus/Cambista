package com.ricindigus.cambista.di

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.os.Build
import com.google.gson.Gson
import com.ricindigus.cambista.datasource.remote.apis.authentication.api.AuthenticationApi
import com.ricindigus.cambista.datasource.remote.apis.authentication.api.IAuthenticationApi
import com.ricindigus.cambista.datasource.remote.apis.authentication.api.IAuthenticationApiService
import com.ricindigus.cambista.datasource.remote.service.NetworkStatusChecker
import com.ricindigus.cambista.datasource.remote.service.buildRetrofit
import com.ricindigus.cambista.utils.ConstantsUtils
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit

val applicationModule = module {
    single { buildRetrofit() }
    single { provideApiService(get(), IAuthenticationApiService::class.java) }
    single<IAuthenticationApi> { AuthenticationApi(get()) }

    factory { Gson() }
    factory {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            NetworkStatusChecker(androidContext().getSystemService(ConnectivityManager::class.java))
        else
            NetworkStatusChecker(androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
    }
    single<SharedPreferences>{ androidContext().getSharedPreferences(ConstantsUtils.PREFERENCES_NAME, Context.MODE_PRIVATE) }
}

fun <T> provideApiService(retrofit: Retrofit, service: Class<T>?): T{
    return retrofit.create(service)
}