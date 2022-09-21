package di

import me.daniil.common.data.cache.DatabaseDriverFactory
import me.daniil.common.presentation.MainScreenViewModel
import org.koin.dsl.module

val desktopModule = module {
    single { DatabaseDriverFactory() }
    factory { MainScreenViewModel(get()) }
}