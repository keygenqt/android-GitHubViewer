package com.keygenqt.stack_2021.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.keygenqt.stack_2021.R
import java.util.*

const val LANGUAGE_BASH = "shell"
const val LANGUAGE_C = "c"
const val LANGUAGE_CPLUSPLUS = "c++"
const val LANGUAGE_DART = "dart"
const val LANGUAGE_ELIXIR = "elixir"
const val LANGUAGE_ERLANG = "erlang"
const val LANGUAGE_GROOVY = "groovy"
const val LANGUAGE_HASKELL = "haskell"
const val LANGUAGE_JAVA = "java"
const val LANGUAGE_JAVASCRIPT = "javascript"
const val LANGUAGE_KOTLIN = "kotlin"
const val LANGUAGE_PHP = "php"
const val LANGUAGE_PYTHON = "python"
const val LANGUAGE_RUBY = "ruby"
const val LANGUAGE_RUST = "rust"
const val LANGUAGE_SCALA = "scala"

@Composable
fun LanguageImage(
    language: String,
    modifier: Modifier
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
                    LANGUAGE_BASH -> R.drawable.ic_pl_bash_plain
                    LANGUAGE_C -> R.drawable.ic_pl_c_plain
                    LANGUAGE_CPLUSPLUS -> R.drawable.ic_pl_cplusplus_plain
                    LANGUAGE_DART -> R.drawable.ic_pl_dart_plain
                    LANGUAGE_ELIXIR -> R.drawable.ic_pl_elixir_plain
                    LANGUAGE_ERLANG -> R.drawable.ic_pl_erlang_plain
                    LANGUAGE_GROOVY -> R.drawable.ic_pl_groovy_plain
                    LANGUAGE_HASKELL -> R.drawable.ic_pl_haskell_plain
                    LANGUAGE_JAVA -> R.drawable.ic_pl_java_plain
                    LANGUAGE_JAVASCRIPT -> R.drawable.ic_pl_javascript_plain
                    LANGUAGE_KOTLIN -> R.drawable.ic_pl_kotlin_plain
                    LANGUAGE_PHP -> R.drawable.ic_pl_php_plain
                    LANGUAGE_PYTHON -> R.drawable.ic_pl_python_plain
                    LANGUAGE_RUBY -> R.drawable.ic_pl_ruby_plain
                    LANGUAGE_RUST -> R.drawable.ic_pl_rust_plain
                    LANGUAGE_SCALA -> R.drawable.ic_pl_scala_plain
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
