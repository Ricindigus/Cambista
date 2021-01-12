package com.ricindigus.cambista.modules.main.di

import com.ricindigus.cambista.modules.main.repository.HomeRepository
import com.ricindigus.cambista.modules.main.repository.IHomeRepository
import com.ricindigus.cambista.modules.main.views.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    single <IHomeRepository>{ HomeRepository(get()) }
    viewModel { HomeViewModel(get()) }
}