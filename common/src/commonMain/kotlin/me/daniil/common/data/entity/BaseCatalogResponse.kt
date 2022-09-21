package me.daniil.common.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseCatalogResponse<T>(
    @SerialName("metadataName")
    val metadataName: String?,
    @SerialName("count")
    val count: Int?,
    @SerialName("data")
    val data: List<T>
){}