typealias ver = com.keygenqt.internal.Versions
typealias dep = com.keygenqt.internal.Dependencies

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("internal")
}

android {

    compileSdk = ver.android.compileSdk
    buildToolsVersion = ver.android.buildTools

    defaultConfig {
        applicationId = "com.keygenqt.stack_2021"
        minSdk = ver.android.minSdk
        targetSdk = ver.android.targetSdk
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
        kotlinCompilerExtensionVersion = ver.library.compose
    }
}

dependencies {
    testImplementation(dep.test.junit)

    androidTestImplementation(dep.test.junitExt)
    androidTestImplementation(dep.test.junitUi)
    androidTestImplementation(dep.test.espresso)

    implementation(dep.compose.ui)
    implementation(dep.compose.material)
    implementation(dep.compose.tooling)
    implementation(dep.compose.activity)

    implementation(dep.ktx.core)
    implementation(dep.ktx.lifecycleRuntime)

    implementation(dep.android.material)
    implementation(dep.android.appcompat)
}