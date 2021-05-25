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

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.google.accompanist.glide.rememberGlidePainter
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.keygenqt.stack_2021.models.ModelFollower
import com.keygenqt.stack_2021.models.ModelRepo
import com.keygenqt.stack_2021.ui.common.CommonList
import com.keygenqt.stack_2021.ui.theme.StackTheme

@Composable
fun Followers(
    modifier: Modifier = Modifier,
    models: LazyPagingItems<ModelFollower>
) {
    CommonList(
        modifier = modifier,
        models = models,
        state = rememberSwipeRefreshState(models.loadState.refresh is LoadState.Loading)
    ) { model ->
        ItemFollower(model = model)
    }
}

@Composable
fun ItemFollower(
    model: ModelFollower,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable(
                onClick = {
                    CustomTabsIntent
                        .Builder()
                        .build()
                        .launchUrl(context, Uri.parse("https://github.com/${model.login}"))
                }
            ),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(8.dp)
        ) {
            val (image, body) = createRefs()
            Image(
                painter = rememberGlidePainter(model.avatarUrl),
                contentDescription = model.login,
                modifier = Modifier
                    .size(56.dp, 56.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
            )
            ConstraintLayout(
                modifier = Modifier
                    .padding(start = 6.dp)
                    .constrainAs(body) {
                        top.linkTo(image.top)
                        bottom.linkTo(image.bottom)
                        start.linkTo(image.end)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
            ) {
                val (name, date) = createRefs()
                Text(
                    text = model.login,
                    style = MaterialTheme.typography.h6,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 4.dp)
                        .constrainAs(name) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            bottom.linkTo(date.top)
                        }
                )
                Text(
                    text = model.type,
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 4.dp)
                        .constrainAs(date) {
                            top.linkTo(name.bottom)
                            start.linkTo(parent.start)
                            bottom.linkTo(parent.bottom)
                        }
                )
            }
        }
    }
}

@Preview
@Composable
fun ItemFollowerPreviewLight() {
    StackTheme(darkTheme = false) {
        ItemFollower(model = ModelFollower.mock())
    }
}

@Preview
@Composable
fun ItemFollowerPreviewDark() {
    StackTheme(darkTheme = true) {
        ItemFollower(model = ModelFollower.mock())
    }
}