package me.daniil.common.data.cache

import me.daniil.common.AppDatabase
import me.daniil.common.data.entity.FieldNet
import me.daniil.common.data.entity.toFieldNet

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllField()
        }
    }
    internal fun getAllLaunches(): List<FieldNet> {
        return dbQuery.selectAllFields().executeAsList().map { it.toFieldNet() }
    }
    internal fun createFields(launches: List<FieldNet>) {
        dbQuery.transaction {
            launches.forEach { launch ->
                 insertField(launch)
            }
        }
    }

    private fun insertField(field: FieldNet) {
        dbQuery.insertField(
            field.guid,
            field.name,
            field.region,
            field.subdivisionGuid,
            field.deletionMark
        )
    }
}