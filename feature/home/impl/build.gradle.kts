plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.android.lint)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {

    android {
        namespace = "com.example.feature.home.impl"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.compose.runtime)
                implementation(libs.compose.foundation)
                implementation(libs.compose.material3)
                implementation(libs.compose.ui)
                implementation(libs.compose.uiToolingPreview)

                implementation(libs.androidx.lifecycle.viewmodelCompose)
                implementation(libs.androidx.lifecycle.runtimeCompose)

                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)
                implementation(libs.koin.compose)
                implementation(libs.koin.compose.viewmodel)

                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.logging)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.collections.immutable)

                implementation(libs.orbit.mvi.core)
                implementation(libs.orbit.mvi.compose)
                implementation(libs.orbit.mvi.viewmodel)

                implementation(libs.coil.core)
                implementation(libs.coil.compose)
                implementation(libs.coil.network.ktor3)

                implementation(libs.kache)

                implementation(projects.feature.home.api)

                implementation(projects.core.network)
                implementation(projects.core.resource)
            }
        }
        androidMain {
            dependencies {
                implementation(libs.ktor.client.okhttp)
                implementation(libs.coil.network.okhttp)
            }
        }
        jvmMain {
            dependencies {
                implementation(libs.ktor.client.cio)
            }
        }
    }
}