import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.desktopModule
import me.daniil.common.di.commonModule
import me.daniil.common.presentation.MainScreen
import me.daniil.common.presentation.MainScreenViewModel
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.inject


fun main() = application {
    val viewModel: MainScreenViewModel by inject(MainScreenViewModel::class.java)
    startKoin {
        modules(listOf(commonModule, desktopModule))
    }
    Window(onCloseRequest = ::exitApplication) {
        MaterialTheme {
            MainScreen(viewModel)
        }
    }
}