typealias and = com.keygenqt.internal.Android
typealias dep = com.keygenqt.internal.Dependencies

plugins {
    id("dagger.hilt.android.plugin")
    id("com.android.application")
    id("com.diffplug.spotless") version "5.12.5"
    id("org.jetbrains.dokka")
    id("kotlin-android")
    id("internal")

    kotlin("kapt")
    kotlin("plugin.serialization")
}

// https://github.com/diffplug/spotless/tree/main/plugin-gradle#kotlin
spotless {
    kotlin {
        target("**/*.kt")
        licenseHeaderFile("${project.rootProject.projectDir}/spotless.license.kt")
    }
    kotlinGradle {
        target("*.gradle.kts")
        ktlint()
    }
}

// https://kotlin.github.io/dokka/1.4.0/user_guide/gradle/usage/#configuration-options
tasks.dokkaHtml.configure {
    outputDirectory.set(project.rootProject.projectDir.resolve("dokka"))
    moduleName.set("app")
    dokkaSourceSets {
        named("main") {
            noAndroidSdkLink.set(false)
        }
    }
}

android {

    compileSdk = and.compileSdk
    buildToolsVersion = and.buildTools

    defaultConfig {
        // secret token
        buildConfigField("String", "GITHUB_TOKEN", findProperty("github_token").toString())

        applicationId = "com.keygenqt.stack_2021"
        minSdk = and.minSdk
        targetSdk = and.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = com.keygenqt.internal.Versions.compose
    }
}

dependencies {
    dep.compose.apply { // https://developer.android.com/jetpack/compose
        implementation(ui)
        implementation(material)
        implementation(tooling)
        implementation(constraint)
        implementation(layout)
        implementation(pagingCompose)
        implementation(icons)
        implementation(hiltNavigationCompose)
        implementation(livedata)
    }

    dep.accompanist.apply { // https://google.github.io/accompanist/
        implementation(insets)
        implementation(glide)
        implementation(swipeRefresh)
    }

    dep.hilt.apply { // https://dagger.dev/hilt/
        implementation(hiltAndroid)
        kapt(hiltCompiler)
        kapt(daggerHiltCompiler)
        kaptAndroidTest(daggerHiltCompiler)
    }

    dep.security.apply { // https://developer.android.com/topic/security/data
        implementation(crypto)
        implementation(identityCredential)
    }

    dep.room.apply { // https://developer.android.com/jetpack/androidx/releases/room
        implementation(runtime)
        implementation(ktx)
        kapt(compiler)
    }

    dep.retrofit.apply { // https://square.github.io/retrofit/
        implementation(converterGson)
        implementation(retrofit2)
        implementation(interceptor)
    }

    dep.test.apply { // https://developer.android.com/studio/test
        testImplementation(junit)
        androidTestImplementation(junitExt)
        androidTestImplementation(junitUi)
        androidTestImplementation(espresso)
        androidTestImplementation(hiltAndroidTesting)
    }

    dep.other.apply { // Miscellaneous required libraries
        implementation(timber)
        implementation(startup)
        implementation(material)
        implementation(serialization)
        implementation(customTabs)
        implementation(kotlinxDatetime)
        implementation(ktxCore)
        implementation(paging)
        dokkaHtmlPlugin(dokka)
    }
}
