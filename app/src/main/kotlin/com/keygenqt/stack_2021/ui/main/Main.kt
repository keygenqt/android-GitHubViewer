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

import android.os.Handler
import android.os.Looper
import android.widget.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.*
import androidx.hilt.navigation.compose.*
import androidx.navigation.*
import androidx.navigation.compose.*
import com.keygenqt.stack_2021.ui.home.*
import com.keygenqt.stack_2021.ui.main.*
import com.keygenqt.stack_2021.ui.other.*
import dev.chrisbanes.accompanist.insets.*
import timber.log.Timber

sealed class NavScreen(val route: String) {
    object Splash : NavScreen("Splash")
    object Repos : NavScreen("Repos") {
        const val routeWithArgument: String = "Repos/{title}"
        const val argument0: String = "title"
    }
}

@Composable
fun ComposableMain() {
    val navController = rememberNavController()
    val context = LocalContext.current

    ProvideWindowInsets {
        NavHost(navController = navController, startDestination = NavScreen.Splash.route) {
            composable(NavScreen.Splash.route) { backStackEntry ->
                val viewModel = hiltNavGraphViewModel<MainViewModel>(backStackEntry = backStackEntry)
                Splash(viewModel)
                viewModel.link.observe(LocalLifecycleOwner.current) {
                    Handler(Looper.getMainLooper()).postDelayed({ // some work
                        navController.navigate("${NavScreen.Repos.route}/$it")
                    }, 100)
                }
                viewModel.alert.observe(LocalLifecycleOwner.current) {
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                }
            }
            composable(
                route = NavScreen.Repos.routeWithArgument,
                arguments = listOf(
                    navArgument(NavScreen.Repos.argument0) { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val viewModel = hiltNavGraphViewModel<MainViewModel>(backStackEntry = backStackEntry)
                val title = backStackEntry.arguments?.getString(NavScreen.Repos.argument0) ?: return@composable
                TabsHome(title, viewModel = viewModel) { type, id ->
                    Timber.e(type.name)
                    Timber.e(id.toString())
                }
            }
        }
    }
}


