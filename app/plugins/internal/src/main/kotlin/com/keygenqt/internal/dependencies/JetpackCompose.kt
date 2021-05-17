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

object JetpackCompose {
    /**
     * [Core Kotlin Extensions](https://mvnrepository.com/artifact/androidx.core/core-ktx) Kotlin extensions for 'core' artifact
     */
    const val jetpack = "androidx.core:core-ktx:${Versions.ktxCore}"

    /**
     * [Compose UI Primitives](https://mvnrepository.com/artifact/androidx.compose.ui/ui)
     * This library contains the primitives that form the Compose UI Toolkit, such as drawing, measurement and layout.
     */
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"

    /**
     * [Compose Material Components](https://mvnrepository.com/artifact/androidx.compose.material/material) Design Components library
     */
    const val material = "androidx.compose.material:material:${Versions.compose}"

    /**
     * [Compose Tooling](https://mvnrepository.com/artifact/androidx.compose.ui/ui-tooling)
     * This library exposes information to our tools for better IDE support.
     */
    const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"

    /**
     * [Activity Compose](https://mvnrepository.com/artifact/androidx.activity/activity-compose) Compose integration with Activity
     */
    const val activity = "androidx.activity:activity-compose:${Versions.composeActivity}"

    /**
     * [Runtime LiveData Compose](https://developer.android.com/jetpack/androidx/releases/compose-runtime#declaring_dependencies)
     */
    const val livedata = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
}