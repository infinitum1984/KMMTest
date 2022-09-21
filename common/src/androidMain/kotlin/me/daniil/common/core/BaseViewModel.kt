package me.daniil.common.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

actual open class BaseViewModel actual constructor(): ViewModel(){
    actual val viewModelScope: CoroutineScope
        get() =  (this as ViewModel).viewModelScope
}

actual val IODispatcher: CoroutineDispatcher
    get() = Dispatchers.IO
