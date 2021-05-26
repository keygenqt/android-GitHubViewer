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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.keygenqt.stack_2021.R
import com.keygenqt.stack_2021.models.ModelRepo
import com.keygenqt.stack_2021.ui.common.CommonLoading
import com.keygenqt.stack_2021.ui.common.LanguageImage
import com.keygenqt.stack_2021.utils.ConstantsDateFormat
import kotlinx.datetime.*
import java.time.format.DateTimeFormatter
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime


@ExperimentalTime
@Composable
fun DetailsRepo(
    viewModel: ViewModelHome,
    upPress: () -> Unit
) {
    val model: ModelRepo? by viewModel.repoView.observeAsState()
    model?.let {
        RepoView(it, upPress)
    }
    CommonLoading(model == null)
}

@ExperimentalTime
@Composable
fun RepoView(
    model: ModelRepo,
    upPress: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Repo: ${model.name}",
                        style = MaterialTheme.typography.subtitle2,
                        color = LocalContentColor.current
                    )
                },
                navigationIcon = {
                    IconButton(onClick = upPress) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.cd_navigate_up)
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
            Column(
                modifier = modifier
                    .verticalScroll(rememberScrollState())
                    .background(MaterialTheme.colors.background)
                    .fillMaxHeight()
            ) {
                LanguageImage(
                    language = model.language,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color.White)
                )
                Text(
                    text = "Name: ${if (model.name.isBlank()) "Empty" else model.name}",
                    style = MaterialTheme.typography.h6,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 4.dp)
                )
                Text(
                    text = "Language: ${if (model.language.isBlank()) "Empty" else model.language}",
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 4.dp)
                )
                Text(
                    text = "Created: ${
                        model.createdAt.toInstant()
                            .toLocalDateTime(TimeZone.currentSystemDefault())
                            .toJavaLocalDateTime()
                            .format(DateTimeFormatter.ofPattern(ConstantsDateFormat.DATE_TIME_DETAILS))
                    }",
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 4.dp)
                )
                Text(
                    text = (Clock.System.now() - model.createdAt.toInstant()).toInt(DurationUnit.SECONDS).let {
                        return@let "Duration: ${
                            listOf(
                                ":%02d".format(it % 60),
                                ":%02d".format((it % 3600) / 60),
                                "%d".format((it % 86400) / 3600),
                                "%d days ".format((it % 31536000) / 86400),
                                "%d years ".format(it / 31536000)
                            )
                                .filter { t -> !t.contains("0 days") && !t.contains("0 years") }
                                .reversed()
                                .joinToString("") { t ->
                                    when (t) {
                                        "1 days" -> "1 day"
                                        "1 years" -> "1 year"
                                        else -> t
                                    }
                                }
                        }"
                    },
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier
                        .padding(top = 2.dp, bottom = 2.dp, start = 8.dp, end = 4.dp)
                )
            }
        },
    )
}