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

package com.keygenqt.stack_2021.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import com.keygenqt.stack_2021.base.LocalBaseViewModel
import com.keygenqt.stack_2021.ui.theme.StackTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.time.ExperimentalTime

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ViewModelMain by viewModels()

    private var route = NavScreen.Splash.route

    @ExperimentalTime
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(LocalBaseViewModel provides viewModel) {
                StackTheme {
                    MainNavGraph { route = it }
                }
            }
        }
    }

    override fun onBackPressed() {
        when (route) {
            NavScreen.Splash.route -> finishAffinity()
            NavScreen.Home.route -> if (viewModel.isShowSnackBar()) finishAffinity() else viewModel.toggleSnackBar()
            else -> super.onBackPressed()
        }
    }
}