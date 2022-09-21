package me.daniil.common.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob


actual open class BaseViewModel{
    actual val viewModelScope: CoroutineScope
        get() = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
}

actual val IODispatcher: CoroutineDispatcher
    get() = Dispatchers.IO
