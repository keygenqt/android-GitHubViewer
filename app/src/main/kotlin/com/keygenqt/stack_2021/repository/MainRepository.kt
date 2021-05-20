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
 
package com.keygenqt.stack_2021.repository

import androidx.annotation.*
import com.keygenqt.stack_2021.base.*
import com.keygenqt.stack_2021.data.dao.*
import com.keygenqt.stack_2021.data.models.*
import com.keygenqt.stack_2021.network.*
import com.skydoves.sandwich.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.*

class MainRepository @Inject constructor(
    private val preferences: BaseSharedPreferences,
    private val mainService: MainService,
    private val projectDao: ProjectDao
) : Repository {

    @WorkerThread
    fun loadRepoUrl(
        login: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        mainService.getUser(login)
            .suspendOnSuccess {
                data?.let {
                    preferences.reposUrl = it.get("repos_url").asString
                    emit(it.get("name").asString)
                    onSuccess()
                }
            }
            .onError { onError(message()) }
            .onException { onError(message()) }
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun loadProjects(
        page: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val models: List<Project> = projectDao.getProjectList()
        if (models.isNotEmpty()) {
            emit(models)
            onSuccess()
        }
        mainService.fetchProjectList(preferences.reposUrl!!, page, 2)
            .suspendOnSuccess {
                data?.let {
                    projectDao.delete()
                    projectDao.insertProjectList(it)
                    emit(it)
                    onSuccess()
                }
            }
            .onError { onError(message()) }
            .onException { onError(message()) }
    }.flowOn(Dispatchers.IO)
}
