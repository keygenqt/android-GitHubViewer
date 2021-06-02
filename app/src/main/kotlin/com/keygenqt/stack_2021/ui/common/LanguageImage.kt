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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.keygenqt.stack_2021.R
import com.keygenqt.stack_2021.ui.theme.StackTheme
import com.keygenqt.stack_2021.utils.ConstantsLanguage
import java.util.*


@Composable
fun LanguageImage(
    language: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
        elevation = 6.dp,
        shape = RoundedCornerShape(6.dp)
    ) {
        Image(
            painter = painterResource(
                when (language.toLowerCase(Locale.getDefault())) {
                    ConstantsLanguage.LANGUAGE_BASH -> R.drawable.ic_pl_bash_plain
                    ConstantsLanguage.LANGUAGE_C -> R.drawable.ic_pl_c_plain
                    ConstantsLanguage.LANGUAGE_CPLUSPLUS -> R.drawable.ic_pl_cplusplus_plain
                    ConstantsLanguage.LANGUAGE_DART -> R.drawable.ic_pl_dart_plain
                    ConstantsLanguage.LANGUAGE_ELIXIR -> R.drawable.ic_pl_elixir_plain
                    ConstantsLanguage.LANGUAGE_ERLANG -> R.drawable.ic_pl_erlang_plain
                    ConstantsLanguage.LANGUAGE_GROOVY -> R.drawable.ic_pl_groovy_plain
                    ConstantsLanguage.LANGUAGE_HASKELL -> R.drawable.ic_pl_haskell_plain
                    ConstantsLanguage.LANGUAGE_JAVA -> R.drawable.ic_pl_java_plain
                    ConstantsLanguage.LANGUAGE_JAVASCRIPT -> R.drawable.ic_pl_javascript_plain
                    ConstantsLanguage.LANGUAGE_KOTLIN -> R.drawable.ic_pl_kotlin_plain
                    ConstantsLanguage.LANGUAGE_PHP -> R.drawable.ic_pl_php_plain
                    ConstantsLanguage.LANGUAGE_PYTHON -> R.drawable.ic_pl_python_plain
                    ConstantsLanguage.LANGUAGE_RUBY -> R.drawable.ic_pl_ruby_plain
                    ConstantsLanguage.LANGUAGE_RUST -> R.drawable.ic_pl_rust_plain
                    ConstantsLanguage.LANGUAGE_SCALA -> R.drawable.ic_pl_scala_plain
                    else -> R.drawable.ic_github_original
                }
            ),
            contentDescription = null, // decorative
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp),
        )
    }
}

@Preview
@Composable
fun LanguageImagePreviewLight() {
    StackTheme(darkTheme = false) {
        LanguageImage(language = ConstantsLanguage.LANGUAGE_BASH)
    }
}

@Preview
@Composable
fun LanguageImagePreviewDark() {
    StackTheme(darkTheme = true) {
        LanguageImage(language = ConstantsLanguage.LANGUAGE_JAVASCRIPT)
    }
}
