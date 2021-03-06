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
 
package com.keygenqt.stack_2021.ui.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.paging.ExperimentalPagingApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.keygenqt.stack_2021.extension.isError
import com.keygenqt.stack_2021.extension.isSucceeded
import com.keygenqt.stack_2021.ui.common.ErrorConnect
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalPagingApi
@ExperimentalCoroutinesApi
@Composable
fun StartApp(
    viewModel: ViewModelHome,
    navigateToDetailsRepo: (Long) -> Unit,
) {

    rememberSystemUiController().setStatusBarColor(
        color = MaterialTheme.colors.primaryVariant,
        darkIcons = isSystemInDarkTheme()
    )

    val user by viewModel.loadingUser.collectAsState(initial = null)
    when {
        user.isSucceeded -> {
            TabsHome(
                viewModel = viewModel,
                navigateToDetailsRepo = navigateToDetailsRepo,
            )
        }
        user.isError -> ErrorConnect { viewModel.repeatLoadingUser() }
        else -> Splash()
    }
}