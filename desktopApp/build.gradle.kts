import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

dependencies {
    implementation(projects.shared)

    implementation(compose.desktop.currentOs)
    implementation(libs.kotlinx.coroutinesSwing)

    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.core)

    implementation(libs.compose.uiToolingPreview)
}

compose.desktop {
    application {
        mainClass = "com.example.gamevault.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.example.gamevault"
            packageVersion = "1.0.0"
        }

        /*jvmArgs(
            "-Dhttp.proxyHost=127.0.0.1",
            "-Dhttp.proxyPort=12334",
            "-Dhttps.proxyHost=127.0.0.1",
            "-Dhttps.proxyPort=12334"
        )*/
    }
}