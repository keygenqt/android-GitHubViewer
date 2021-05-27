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
 
package com.keygenqt.stack_2021.ui.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.keygenqt.stack_2021.R
import com.keygenqt.stack_2021.extension.runSucceeded
import com.keygenqt.stack_2021.ui.theme.BlackLight
import com.keygenqt.stack_2021.ui.theme.Blue50_30

@Composable
fun Splash(
    viewModel: ViewModelSplash,
    loadingUserDone: () -> Unit
) {
    viewModel.loadingUser.observeAsState().value.runSucceeded {
        loadingUserDone.invoke()
    }
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
                Image(
                    painter = painterResource(R.drawable.ic_launcher),
                    contentDescription = null
                )
                CircularProgressIndicator(
                    color = Blue50_30,
                    modifier = Modifier.width(24.dp)
                )
            }
        }
    }
}