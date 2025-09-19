// Root build.gradle.kts
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library)     apply false
    alias(libs.plugins.kotlin.android)      apply false
}

// 🔒 Pin AndroidX to AGP-8.7.3–friendly versions for every module
subprojects {
    configurations.all {
        resolutionStrategy {
            force("androidx.core:core:1.12.0")
            force("androidx.core:core-ktx:1.12.0")
            force("androidx.appcompat:appcompat:1.6.1")
            force("com.google.android.material:material:1.10.0")
        }
    }
}
