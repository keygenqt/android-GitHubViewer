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

import android.content.SharedPreferences
import com.keygenqt.stack_2021.models.ModelUser
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class AppPreferences(private val p: SharedPreferences) {

    companion object {
        private const val USER = "USER"
        private const val LAST_UPDATE_REPOS = "LAST_UPDATE_REPOS_"
    }

    var lastUpdateRepos: Long
        get() = p.getLong(LAST_UPDATE_REPOS, 0L)
        set(value) = p.edit().putLong(LAST_UPDATE_REPOS, value).apply()

    val followersUrl: String
        get() = modelUser!!.followersUrl

    val reposUrl: String
        get() = modelUser!!.reposUrl

    var modelUser: ModelUser?
        get() = p.getString(USER, null)?.let { Json.decodeFromString<ModelUser>(it) }
        set(value) = value
            ?.let { p.edit().putString(USER, Json.encodeToString(value)).apply() }
            ?: p.edit().remove(USER).apply()
}