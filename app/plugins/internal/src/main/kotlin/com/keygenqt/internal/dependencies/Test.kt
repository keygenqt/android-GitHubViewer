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

object Test {
    /**
     * [JUnit](https://mvnrepository.com/artifact/junit/junit) JUnit is a unit testing framework for Java, created by Erich Gamma and Kent Beck.
     */
    const val junit = "junit:junit:4.+"

    /**
     * [Android JUnit](https://mvnrepository.com/artifact/androidx.test.ext/junit)
     */
    const val junitExt = "androidx.test.ext:junit:${Versions.junit}"

    /**
     * [Compose Testing For JUnit4](https://mvnrepository.com/artifact/androidx.compose.ui/ui-test-junit4) Compose testing integration with JUnit4
     */
    const val junitUi = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"

    /**
     * [AndroidX Test Library](https://mvnrepository.com/artifact/androidx.test.espresso/espresso-core)
     * The AndroidX Test Library provides an extensive framework for testing Android apps
     */
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    /**
     * [Hilt Android Testing](https://mvnrepository.com/artifact/com.google.dagger/hilt-android-testing)
     * A fast dependency injector for Android and Java.
     */
    const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:${Versions.hiltCore}"
}
