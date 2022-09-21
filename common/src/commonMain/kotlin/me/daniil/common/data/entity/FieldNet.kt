package me.daniil.common.data.entity

import kotlinx.serialization.Serializable
import me.daniil.common.Field

@Serializable
data class FieldNet(
    val guid: String,
    val name: String,
    val region: String,
    val subdivisionGuid: String,
    val deletionMark: Boolean,
)

fun Field.toFieldNet() = FieldNet(
    guid,
    name,
    region,
    subdivisionGuid,
    deletionMark?:false
)
