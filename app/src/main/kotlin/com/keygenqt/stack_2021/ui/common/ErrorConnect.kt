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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SignalWifiBad
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.keygenqt.stack_2021.R
import com.keygenqt.stack_2021.ui.theme.BlackLight
import com.keygenqt.stack_2021.ui.theme.Purple700
import com.keygenqt.stack_2021.ui.theme.Red100
import com.keygenqt.stack_2021.ui.theme.StackTheme

@Composable
fun ErrorConnect(repeat: () -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackLight)
    ) {
        val (constraintLayout) = createRefs()
        ConstraintLayout(
            modifier = Modifier
                .background(Color.Transparent)
                .constrainAs(constraintLayout) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.SignalWifiBad,
                    contentDescription = "Signal Wifi Bad",
                    tint = Red100,
                    modifier = Modifier.size(100.dp)
                )
                Text(
                    text = stringResource(id = R.string.no_connection),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(30.dp)
                )
                Button(
                    onClick = repeat,
                    colors = ButtonDefaults.textButtonColors(backgroundColor = Color.White)
                ) {
                    Text(
                        text = stringResource(id = R.string.no_connection_button),
                        color = Purple700
                    )
                }

            }
        }
    }
}

@Preview
@Composable
fun ErrorConnectPreviewLight() {
    StackTheme(darkTheme = false) {
        ErrorConnect {}
    }
}

@Preview
@Composable
fun ErrorConnectPreviewDark() {
    StackTheme(darkTheme = true) {
        ErrorConnect {}
    }
}