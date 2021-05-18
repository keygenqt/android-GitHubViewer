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
 
package com.keygenqt.stack_2021.base

import android.content.*

class BaseSharedPreferences(private val p: SharedPreferences) {

    companion object {
        private const val REPOS_URL = "REPOS_URL"
    }

    var reposUrl: String?
        get() = p.getString(REPOS_URL, null)
        set(value) = value?.let { p.edit().putString(REPOS_URL, value).apply() } ?: run { p.edit().remove(REPOS_URL).apply() }
}