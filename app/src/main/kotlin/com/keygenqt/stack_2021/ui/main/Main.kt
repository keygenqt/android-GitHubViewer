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

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.keygenqt.stack_2021.ui.home.TabsHome
import com.keygenqt.stack_2021.ui.home.ViewModelHome
import com.keygenqt.stack_2021.ui.other.Splash
import com.keygenqt.stack_2021.ui.other.ViewModelSplash
import timber.log.Timber

sealed class NavScreen(val route: String) {
    object Splash : NavScreen("Splash")
    object Repos : NavScreen("Repos")
}

@Composable
fun ComposableMain() {
    val navController = rememberNavController()
    ProvideWindowInsets {
        NavHost(navController = navController, startDestination = NavScreen.Splash.route) {
            composable(NavScreen.Splash.route) { backStackEntry ->
                val viewModel = hiltViewModel<ViewModelSplash>(backStackEntry = backStackEntry)
                Splash(viewModel) {
                    navController.navigate(NavScreen.Repos.route)
                }
            }
            composable(NavScreen.Repos.route) { backStackEntry ->
                val viewModel = hiltViewModel<ViewModelHome>(backStackEntry = backStackEntry)
                TabsHome(viewModel = viewModel) { type, id ->
                    Timber.e(type.name)
                    Timber.e(id.toString())
                }
            }
        }
    }
}


