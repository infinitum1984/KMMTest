import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "1.1.0"
    id("com.android.library")
    id("com.squareup.sqldelight")
    kotlin("plugin.serialization")
}

group = "me.daniil"
version = "1.0"

val sqlDelightVersion = "1.5.3"
val ktorVersion = "1.6.1"
val koin = "3.2.0"

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                val serializationVersion = "1.2.2"
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                implementation("io.ktor:ktor-client-auth:$ktorVersion")
                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
                implementation("io.insert-koin:koin-core:${koin}")
            }
        }
        val androidMain by getting {
            dependencies {
                api(compose.preview)
                api("androidx.appcompat:appcompat:1.4.1")
                api("androidx.core:core-ktx:1.7.0")
                implementation("io.ktor:ktor-client-android:$ktorVersion")
                implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")
                val lifecycle_version = "2.5.1"
                // ViewModel
                implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
                // ViewModel utilities for Compose
                implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
                implementation ("com.squareup.sqldelight:sqlite-driver:$sqlDelightVersion")
                implementation("io.ktor:ktor-client-apache:$ktorVersion")            }
        }
    }
}

android {
    compileSdkVersion(31)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(31)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
sqldelight {
    database("AppDatabase") {
        packageName = "me.daniil.common"
    }
}