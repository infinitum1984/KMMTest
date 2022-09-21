package me.daniil.android

import android.app.Application
import me.daniil.android.di.androidModule
import me.daniil.common.data.FieldsRepository
import me.daniil.common.data.cache.DatabaseDriverFactory
import me.daniil.common.di.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class DemoApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DemoApp)
            modules(listOf(commonModule, androidModule))
        }
    }
}