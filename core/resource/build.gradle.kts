plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.android.lint)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {

    android {
        namespace = "com.example.resource"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
        androidResources.enable = true
    }

    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.compose.runtime)
                api(libs.compose.components.resources)
            }
        }
    }

}

compose.resources {
    publicResClass = true
    generateResClass = auto
}