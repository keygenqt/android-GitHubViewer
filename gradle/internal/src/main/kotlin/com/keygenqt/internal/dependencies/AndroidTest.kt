package com.keygenqt.internal.dependencies

import com.keygenqt.internal.*

object AndroidTest {
    const val junit = "junit:junit:4.+"
    const val junitExt = "androidx.test.ext:junit:${Versions.test.junit}"
    const val junitUi = "androidx.compose.ui:ui-test-junit4:${Versions.library.compose}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.test.espresso}"
}