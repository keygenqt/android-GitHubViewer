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
     * [Runtime LiveData Compose](https://developer.android.com/jetpack/androidx/releases/compose-runtime#declaring_dependencies)
     */
    const val livedata = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"

    /**
     * [Navigation Compose Hilt Extension](https://mvnrepository.com/artifact/androidx.hilt/hilt-navigation-compose)
     * Navigation Compose Hilt Extension
     */
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltComposeNavigation}"
}