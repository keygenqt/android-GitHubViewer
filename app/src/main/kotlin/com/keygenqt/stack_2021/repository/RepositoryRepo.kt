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

import androidx.annotation.WorkerThread
import com.keygenqt.stack_2021.base.SharedPreferences
import com.keygenqt.stack_2021.data.DaoRepo
import com.keygenqt.stack_2021.models.ModelRepo
import com.keygenqt.stack_2021.network.ServiceRepo
import com.keygenqt.stack_2021.network.ServiceUser
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryRepo @Inject constructor(
    private val preferences: SharedPreferences,
    private val mainService: ServiceRepo,
    private val dao: DaoRepo
) {

    @WorkerThread
    fun loadRepos(
        page: Int,
        onDone: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        val models: List<ModelRepo> = dao.getList()
        if (models.isNotEmpty()) {
            emit(models)
            onDone()
        }
        mainService.fetchRepoList(preferences.modelUser!!.reposUrl, page, 20)
            .suspendOnSuccess {
                data?.let {
                    dao.delete()
                    dao.insertList(it)
                    emit(it)
                    onDone()
                }
            }
            .onError { onError(message()) }
            .onException { onError(message()) }
    }.flowOn(Dispatchers.IO)
}
