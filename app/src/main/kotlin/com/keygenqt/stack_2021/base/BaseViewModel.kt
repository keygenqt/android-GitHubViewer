package com.keygenqt.stack_2021.base

import androidx.compose.runtime.staticCompositionLocalOf
import com.keygenqt.stack_2021.ui.main.ViewModelMain

val LocalBaseViewModel = staticCompositionLocalOf<ViewModelMain> { error("No MainViewModel found!") }
