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
 
package com.keygenqt.stack_2021.data.repos.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.keygenqt.stack_2021.base.AppPreferences
import com.keygenqt.stack_2021.data.AppDatabase
import com.keygenqt.stack_2021.data.repos.DaoRepo
import com.keygenqt.stack_2021.data.repos.impl.RepositoryRepo
import com.keygenqt.stack_2021.models.ModelRepo
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeUnit

@ExperimentalPagingApi
class RemoteMediatorRepo(
    private val database: AppDatabase,
    private val preferences: AppPreferences,
    private val repositoryRepo: RepositoryRepo,
) : RemoteMediator<Int, ModelRepo>() {

    private val repoDao: DaoRepo = database.repo()

    override suspend fun initialize(): InitializeAction {
        val cacheTimeout = TimeUnit.HOURS.toMillis(1)
        // Refresh once per hour
        return if (System.currentTimeMillis() - preferences.lastUpdateRepos >= cacheTimeout) {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        } else {
            InitializeAction.SKIP_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ModelRepo>
    ): MediatorResult {
        return try {
            val loadPage = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    state.lastItemOrNull()?.page?.plus(1)
                }
            }

            val response = repositoryRepo.getModels(
                page = loadPage ?: 1
            )

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    preferences.lastUpdateRepos = System.currentTimeMillis()
                    repoDao.clearAll()
                }
                repoDao.insertAll(response)
            }

            MediatorResult.Success(
                endOfPaginationReached = response.isEmpty()
            )

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}