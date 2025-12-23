// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // App module (optional)
    alias(libs.plugins.android.application) apply false

    // Library module (required if you have a library module)
    alias(libs.plugins.android.library) apply false

    // Kotlin
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}