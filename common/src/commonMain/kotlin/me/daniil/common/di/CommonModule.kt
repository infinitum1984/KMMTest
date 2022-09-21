package me.daniil.common.di

import me.daniil.common.data.FieldsRepository
import me.daniil.common.data.cache.Database
import me.daniil.common.data.network.FieldsApi
import org.koin.dsl.module

val commonModule = module {
    single { FieldsRepository(get(),get()) }
    single { FieldsApi() }
    single { Database(get()) }
}