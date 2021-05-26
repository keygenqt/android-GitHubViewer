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

package com.keygenqt.stack_2021.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.keygenqt.stack_2021.extension.visible
import timber.log.Timber

@Composable
fun <T : Any> CommonList(
    modifier: Modifier = Modifier,
    models: LazyPagingItems<T>,
    state: SwipeRefreshState,
    content: @Composable (T) -> Unit
) {
    if (models.itemCount != 0) {
        SwipeRefresh(
            state = state,
            onRefresh = {
                models.refresh()
            },
            indicator = { st, tr ->
                SwipeRefreshIndicator(
                    state = st,
                    refreshTriggerDistance = tr,
                    contentColor = MaterialTheme.colors.primary,
                )
            },
            modifier = modifier
                .fillMaxSize()
                .statusBarsPadding()
                .background(MaterialTheme.colors.background)
        ) {
            LazyColumn(
                modifier = Modifier
                    .visible(models.loadState.refresh !is LoadState.Loading)
            ) {
                items(models) { model ->
                    content.invoke(model!!)
                }
                models.apply {
                    when {
                        loadState.append is LoadState.Loading -> {
                            item { LoadingItem() }
                        }
                        loadState.refresh is LoadState.Error -> {
                            val error = models.loadState.refresh as LoadState.Error
                            item {
                                Timber.e("Refresh error: $error.error.localizedMessage")
                            }
                        }
                        loadState.append is LoadState.Error -> {
                            val error = models.loadState.refresh as LoadState.Error
                            item {
                                Timber.e("Append error: $error.error.localizedMessage")
                            }
                        }
                    }
                }
            }
        }
    }
    CommonLoading(models.loadState.refresh is LoadState.Loading)
}


@Composable
fun LoadingItem() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}