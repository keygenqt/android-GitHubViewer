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

import com.keygenqt.internal.Versions

object Test {
    /**
     * [JUnit](https://mvnrepository.com/artifact/junit/junit)
     * JUnit is a unit testing framework for Java, created by Erich Gamma and Kent Beck.
     */
    const val junit = "junit:junit:4.+"

    /**
     * [MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver)
     * A scriptable web server for testing HTTP clients
     */
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"

    /**
     * [Mockito](https://github.com/mockito/mockito)
     * Most popular mocking framework for Java
     */
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"

    /**
     * [UI Test Junit4](https://developer.android.com/jetpack/compose/testing#setup)
     */
    const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"

    /**
     * [UI Test Manifest](https://developer.android.com/jetpack/compose/testing#setup)
     */
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
}
