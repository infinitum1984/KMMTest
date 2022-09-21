package me.daniil.common.core

import kotlinx.coroutines.*


expect open class BaseViewModel(){
    val viewModelScope: CoroutineScope
}

expect val IODispatcher: CoroutineDispatcher