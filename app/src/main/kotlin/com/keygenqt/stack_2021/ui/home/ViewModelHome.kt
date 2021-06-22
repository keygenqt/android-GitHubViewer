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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.keygenqt.stack_2021.base.ResponseResult
import com.keygenqt.stack_2021.base.SharedPreferences
import com.keygenqt.stack_2021.data.AppDatabase
import com.keygenqt.stack_2021.data.followers.impl.RepositoryFollower
import com.keygenqt.stack_2021.data.followers.paging.PageSourceFollower
import com.keygenqt.stack_2021.data.repos.impl.RepositoryRepo
import com.keygenqt.stack_2021.data.repos.paging.RemoteMediatorRepo
import com.keygenqt.stack_2021.data.user.impl.RepositoryUser
import com.keygenqt.stack_2021.extension.success
import com.keygenqt.stack_2021.models.ModelFollower
import com.keygenqt.stack_2021.models.ModelRepo
import com.keygenqt.stack_2021.models.ModelUser
import com.keygenqt.stack_2021.utils.ConstantsPaging
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
@ExperimentalCoroutinesApi
class ViewModelHome @Inject constructor(
    private val db: AppDatabase,
    private val preferences: SharedPreferences,
    repositoryRepo: RepositoryRepo,
    repositoryFollower: RepositoryFollower,
    private val repositoryUser: RepositoryUser
) : ViewModel() {

    // change tabs
    private val _selectedTab: MutableStateFlow<Int> = MutableStateFlow(0)
    val selectedTab: StateFlow<Int> = _selectedTab

    // first query to get user
    private val _loadingUser: MutableStateFlow<ResponseResult<ModelUser>?> = MutableStateFlow(null)
    val loadingUser = _loadingUser.asStateFlow()

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

    init {
        repeatLoadingUser()
    }

    fun repeatLoadingUser() {
        repositoryUser.loadingUser()
            .onEach {
                it.success { preferences.modelUser = it }
                _loadingUser.value = it
            }
            .launchIn(viewModelScope)
    }

    fun findByIdRepo(id: Long): Flow<ModelRepo?> {
        return db.repo().getModel(id).distinctUntilChanged()
    }

    @MainThread
    fun selectTab(@StringRes tab: Int) {
        _selectedTab.value = tab
    }
}
