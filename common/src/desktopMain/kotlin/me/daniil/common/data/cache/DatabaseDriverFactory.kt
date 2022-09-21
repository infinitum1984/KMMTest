package me.daniil.common.data.cache
import me.daniil.common.AppDatabase
import me.daniil.common.data.cache.DatabaseDriverFactory
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import java.io.File

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        val databasePath = File(System.getenv("APPDATA"),"test.db")
        val driver = JdbcSqliteDriver(url = "jdbc:sqlite:${databasePath.absolutePath}")
        if (!databasePath.exists()) {
            AppDatabase.Schema.create(driver)
        }
        return driver
    }
}