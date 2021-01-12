package com.ricindigus.cambista.modules.authentication.di

import android.content.Context
import android.content.SharedPreferences
import com.ricindigus.cambista.modules.authentication.views.login.LoginViewModel
import com.ricindigus.cambista.modules.authentication.repository.AuthenticationRepository
import com.ricindigus.cambista.modules.authentication.repository.IAuthenticationRepository
import com.ricindigus.cambista.utils.ConstantsUtils.Companion.PREFERENCES_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authenticationModule = module {
    single <IAuthenticationRepository>{ AuthenticationRepository(get()) }
    viewModel { LoginViewModel(get()) }
}