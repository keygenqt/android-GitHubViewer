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

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding
import com.keygenqt.stack_2021.models.ModelRepo
import com.keygenqt.stack_2021.utils.LanguageImage

@Composable
fun Repos(
    modifier: Modifier = Modifier,
    models: List<ModelRepo>,
    selectItem: (HomeTab, Long) -> Unit
) {
    val listState = rememberLazyListState()
    Column(
        modifier = modifier
            .statusBarsPadding()
            .background(MaterialTheme.colors.background)
    ) {
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(4.dp)
        ) {
            items(
                items = models,
                itemContent = { model ->
                    ItemRepo(
                        model = model,
                        selectItem = selectItem
                    )
                }
            )
        }
    }
}

@Composable
fun ItemRepo(
    model: ModelRepo,
    selectItem: (HomeTab, Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable(
                onClick = { selectItem(HomeTab.REPOS, model.id) }
            ),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            LanguageImage(
                language = model.language,
                modifier = Modifier
                    .size(56.dp, 56.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Column {
                Text(
                    text = model.name,
                    style = MaterialTheme.typography.h6,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 4.dp)
                )
                Text(
                    text = model.createdAt,
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 4.dp)
                )
            }
        }
    }
}