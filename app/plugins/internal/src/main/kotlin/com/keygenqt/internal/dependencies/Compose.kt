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
 
package com.keygenqt.internal.dependencies

import com.keygenqt.internal.Versions

object Compose {
    /**
     * [Compose Material Components](https://mvnrepository.com/artifact/androidx.compose.material/material) Design Components library
     */
    const val material = "androidx.compose.material:material:${Versions.compose}"

    /**
     * [Material Icons Extended by Infragistics](https://github.com/IgniteUI/material-icons-extended)
     */
    const val icons = "androidx.compose.material:material-icons-extended:${Versions.compose}"

    /**
     * [Compose UI Primitives](https://developer.android.com/jetpack/androidx/releases/compose-ui)
     * This library contains the primitives that form the Compose UI Toolkit, such as drawing, measurement and layout.
     */
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"

    /**
     * [Compose Layouts](https://mvnrepository.com/artifact/androidx.compose.foundation/foundation-layout)
     */
    const val layout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"

    /**
     * [ConstraintLayout Compose](https://developer.android.com/jetpack/androidx/releases/constraintlayout)
     */
    const val constraint = "androidx.constraintlayout:constraintlayout-compose:${Versions.constraint}"

    /**
     * [Paging Compose](https://developer.android.com/jetpack/androidx/releases/paging)
     */
    const val pagingCompose = "androidx.paging:paging-compose:${Versions.pagingCompose}"

    /**
     * [Compose tooling](https://developer.android.com/jetpack/compose/tooling)
     * This library exposes information to our tools for better IDE support.
     */
    const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"

    /**
     * [Navigation Compose Hilt Extension](https://mvnrepository.com/artifact/androidx.hilt/hilt-navigation-compose)
     * Navigation Compose Hilt Extension
     */
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltComposeNavigation}"
}