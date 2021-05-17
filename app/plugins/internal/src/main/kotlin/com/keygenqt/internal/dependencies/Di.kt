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

object Di {
    /**
     * [Hilt Android](https://mvnrepository.com/artifact/com.google.dagger/hilt-android)
     * A fast dependency injector for Android and Java.
     */
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltCore}"

    /**
     * [Hilt Compiler](https://developer.android.com/training/dependency-injection/hilt-jetpack#workmanager)
     */
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hilt}"

    /**
     * [Navigation Compose Hilt Extension](https://mvnrepository.com/artifact/androidx.hilt/hilt-navigation-compose)
     * Navigation Compose Hilt Extension
     */
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltComposeNavigation}"

    /**
     * [Hilt Processor](https://mvnrepository.com/artifact/com.google.dagger/hilt-compiler)
     * A fast dependency injector for Android and Java.
     */
    const val daggerHiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltCore}"
}