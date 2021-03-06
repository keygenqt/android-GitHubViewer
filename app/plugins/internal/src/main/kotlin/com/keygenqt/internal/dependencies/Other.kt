/*
 * Copyright 2021 Vitaliy Zarubin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
@file:Suppress("unused")
package com.keygenqt.internal.dependencies

import com.keygenqt.internal.*

object Other {
    /**
     * [Material Components For Android](https://mvnrepository.com/artifact/com.google.android.material/material)
     * Material Components for Android is a static library that you can add to your Android application in order to use APIs that provide
     * implementations of the Material Design specification. Compatible on devices running API 14 or later.
     */
    const val material = "com.google.android.material:material:${Versions.material}"

    /**
     * [Timber](https://mvnrepository.com/artifact/com.jakewharton.timber/timber)
     * No-nonsense injectable logging.
     */
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    /**
     * [Android App Startup Runtime](https://mvnrepository.com/artifact/androidx.startup/startup-runtime)
     */
    const val startup = "androidx.startup:startup-runtime:${Versions.startup}"

    /**
     * [Dokka](https://github.com/Kotlin/dokka)
     * Dokka is a documentation engine for Kotlin, performing the same function as javadoc for Java. Just like Kotlin itself, Dokka fully
     * supports mixed-language Java/Kotlin projects. It understands standard Javadoc comments in Java files and KDoc comments in Kotlin files,
     * and can generate documentation in multiple formats including standard Javadoc, HTML and Markdown.
     */
    const val dokka = "org.jetbrains.dokka:kotlin-as-java-plugin:${Versions.dokka}"

    /**
     * [Kotlin multiplatform serialization](https://github.com/Kotlin/kotlinx.serialization)
     */
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"

    /**
     * [Custom Tabs]( https://developer.chrome.com/docs/android/custom-tabs/overview/)
     */
    const val customTabs = "androidx.browser:browser:${Versions.customTabs}"

    /**
     * [Kotlinx DateTime](https://github.com/Kotlin/kotlinx-datetime)
     */
    const val kotlinxDatetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDatetime}"

    /**
     * [Paging](https://developer.android.com/jetpack/androidx/releases/paging)
     */
    const val paging = "androidx.paging:paging-runtime:${Versions.paging}"

    /**
     * [Core Kotlin Extensions](https://developer.android.com/kotlin/ktx#core)
     * Kotlin extensions for 'core' artifact
     */
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktxCore}"

}