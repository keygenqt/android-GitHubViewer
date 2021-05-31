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

package com.keygenqt.stack_2021.ui.home

import androidx.annotation.MainThread
import androidx.annotation.StringRes
import androidx.annotation.WorkerThread
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.keygenqt.stack_2021.base.SharedPreferences
import com.keygenqt.stack_2021.data.AppDatabase
import com.keygenqt.stack_2021.data.followers.impl.RepositoryFollower
import com.keygenqt.stack_2021.data.followers.paging.PageSourceFollower
import com.keygenqt.stack_2021.data.repos.impl.RepositoryRepo
import com.keygenqt.stack_2021.data.repos.paging.RemoteMediatorRepo
import com.keygenqt.stack_2021.models.ModelFollower
import com.keygenqt.stack_2021.models.ModelRepo
import com.keygenqt.stack_2021.utils.ConstantsPaging
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

@HiltViewModel
class ViewModelHome @Inject constructor(
    private val db: AppDatabase,
    preferences: SharedPreferences,
    repositoryRepo: RepositoryRepo,
    private val repositoryFollower: RepositoryFollower
) : ViewModel() {

    private val _selectedTab: MutableStateFlow<Int> = MutableStateFlow(0)
    val selectedTab: StateFlow<Int> = _selectedTab

    // Example of use RemoteMediatorRepo
    @ExperimentalPagingApi
    val repos: Flow<PagingData<ModelRepo>> = Pager(
        config = PagingConfig(pageSize = ConstantsPaging.PER_PAGE),
        remoteMediator = RemoteMediatorRepo(db, preferences, repositoryRepo)
    ) {
        db.repo().pagingSource()
    }.flow

    // Example of use PagingSource
    val followers: Flow<PagingData<ModelFollower>> = Pager(PagingConfig(pageSize = ConstantsPaging.PER_PAGE)) {
        PageSourceFollower(repositoryFollower)
    }.flow.cachedIn(viewModelScope)

    @WorkerThread
    fun findByIdRepo(id: Long): Flow<ModelRepo?> = db.repo().getModel(id).distinctUntilChanged()

    @MainThread
    fun selectTab(@StringRes tab: Int) {
        _selectedTab.value = tab
    }
}
