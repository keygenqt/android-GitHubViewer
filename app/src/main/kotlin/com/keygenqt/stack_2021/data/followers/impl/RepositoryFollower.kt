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
 
package com.keygenqt.stack_2021.data.followers.impl

import com.keygenqt.stack_2021.base.ResponseResult
import com.keygenqt.stack_2021.base.SharedPreferences
import com.keygenqt.stack_2021.data.followers.DaoFollower
import com.keygenqt.stack_2021.data.followers.FollowerRepository
import com.keygenqt.stack_2021.data.followers.ServiceFollower
import com.keygenqt.stack_2021.extension.toModelFollowers
import com.keygenqt.stack_2021.models.ModelFollower
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryFollower @Inject constructor(
    private val preferences: SharedPreferences,
    private val service: ServiceFollower,
    private val dao: DaoFollower
) : FollowerRepository {
    override suspend fun getModels(page: Int): ResponseResult<List<ModelFollower>> {
        return withContext(Dispatchers.IO) {
            try {
                service.listFollowers(preferences.followersUrl, page).body()?.toModelFollowers()?.let { models ->
                    if (page == 1) dao.delete(); dao.insertList(models)
                    delay(1000) // slow internet
                    ResponseResult.Success(models)
                } ?: run {
                    ResponseResult.Success(emptyList())
                }
            } catch (ex: Exception) {
                ResponseResult.Error(ex)
            }
        }
    }
}