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
 
package com.keygenqt.stack_2021.data.repos.impl

import com.keygenqt.stack_2021.base.NotFoundException
import com.keygenqt.stack_2021.base.SharedPreferences
import com.keygenqt.stack_2021.data.repos.ServiceRepo
import com.keygenqt.stack_2021.extension.toModelRepos
import com.keygenqt.stack_2021.models.ModelRepo
import kotlinx.coroutines.delay
import javax.inject.Inject

class RepositoryRepo @Inject constructor(
    private val preferences: SharedPreferences,
    private val service: ServiceRepo
) {
    suspend fun getModels(page: Int): List<ModelRepo> {
        delay(1000) // slow internet
        return service.listRepo(preferences.reposUrl, page).body()?.toModelRepos(page)?.let { models ->
            models
        } ?: run {
            throw NotFoundException()
        }
    }
}
