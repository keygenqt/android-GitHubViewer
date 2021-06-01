package com.keygenqt.stack_2021.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.paging.ExperimentalPagingApi
import com.keygenqt.stack_2021.extension.isError
import com.keygenqt.stack_2021.extension.isSucceeded
import com.keygenqt.stack_2021.ui.common.ErrorConnect
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalPagingApi
@ExperimentalCoroutinesApi
@Composable
fun StartApp(
    viewModel: ViewModelHome,
    navigateToDetailsRepo: (Long) -> Unit,
) {
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