package me.daniil.common.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import me.daniil.common.core.BaseViewModel
import me.daniil.common.core.IODispatcher
import me.daniil.common.data.FieldsRepository
import kotlin.coroutines.CoroutineContext

class MainScreenViewModel(private val fieldsRepository: FieldsRepository) : BaseViewModel() {
    var fieldsState by mutableStateOf(FieldsState())
    private val exceptionHandler: CoroutineContext =
        CoroutineExceptionHandler { _, throwable ->
            fieldsState = fieldsState.copy(error = throwable.message ?: "error", isLoading = false)
        }

    fun loadFields(update: Boolean) {
        viewModelScope.launch(IODispatcher + exceptionHandler) {
            resetStates()
            fieldsState = fieldsState.copy(isLoading = true)
            fieldsState = fieldsState.copy(isLoading = false, list = fieldsRepository.getFields(update))
        }
    }

    private fun resetStates() {
        fieldsState = FieldsState()
    }
}
