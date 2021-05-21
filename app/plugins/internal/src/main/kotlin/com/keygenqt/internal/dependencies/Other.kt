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
     * [Android AppCompat Library](https://mvnrepository.com/artifact/androidx.appcompat/appcompat)
     * The Support Library is a static library that you can add to your Android application in order to use APIs that are either not available for
     * older platform versions or utility APIs that aren't a part of the framework APIs. Compatible on devices running API 14 or later.
     */
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    /**
     * [Material Components For Android](https://mvnrepository.com/artifact/com.google.android.material/material)
     * Material Components for Android is a static library that you can add to your Android application in order to use APIs that provide
     * implementations of the Material Design specification. Compatible on devices running API 14 or later.
     */
    const val material = "com.google.android.material:material:${Versions.material}"

    /**
     * [Timber](https://mvnrepository.com/artifact/com.jakewharton.timber/timber) No-nonsense injectable logging.
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
     * [Sandwich](https://github.com/skydoves/Sandwich)
     * A lightweight and standardized Android network response interface for handling successful data and error responses.
     */
    const val sandwich = "com.github.skydoves:sandwich:${Versions.sandwich}"

    /**
     * [Glide for Jetpack Compose](https://google.github.io/accompanist/glide/)
     * This library brings easy-to-use Painter which can fetch and display images from external sources, such as network, using the Glide image
     * loading library.
     */
    const val glide = "com.google.accompanist:accompanist-glide:${Versions.glide}"

    /**
     * [Kotlin multiplatform serialization](https://github.com/Kotlin/kotlinx.serialization)
     */
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
}