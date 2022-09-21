package me.daniil.common.data

import me.daniil.common.data.cache.Database
import me.daniil.common.data.entity.FieldNet
import me.daniil.common.data.network.FieldsApi

class FieldsRepository(private val database: Database, private val api: FieldsApi) {
    @Throws(Exception::class)
    suspend fun getFields(forceReload: Boolean): List<FieldNet> {
        val cachedLaunches = database.getAllLaunches()
        if (cachedLaunches.isNotEmpty() && !forceReload) {
            return cachedLaunches
        } else {
            return api.getAllLaunches().data.also {
                database.clearDatabase()
                database.createFields(it)
            }
        }
    }
}
