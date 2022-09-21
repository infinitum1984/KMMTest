package me.daniil.android.di

import me.daniil.common.data.cache.DatabaseDriverFactory
import me.daniil.common.presentation.MainScreenViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    single { DatabaseDriverFactory(androidContext()) }
    viewModel { MainScreenViewModel(get()) }
}