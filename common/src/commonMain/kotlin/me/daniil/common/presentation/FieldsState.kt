package me.daniil.common.presentation

import me.daniil.common.data.entity.FieldNet

data class FieldsState(
    val list: List<FieldNet> = listOf(),
    val isLoading: Boolean = false,
    val error: String = ""
)