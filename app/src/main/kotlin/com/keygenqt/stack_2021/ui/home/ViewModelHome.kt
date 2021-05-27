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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.keygenqt.stack_2021.base.LiveCoroutinesViewModel
import com.keygenqt.stack_2021.data.followers.impl.PageSourceFollower
import com.keygenqt.stack_2021.data.followers.impl.RepositoryFollower
import com.keygenqt.stack_2021.data.repos.impl.DataRepo
import com.keygenqt.stack_2021.data.repos.impl.PageSourceRepo
import com.keygenqt.stack_2021.data.repos.impl.RepositoryRepo
import com.keygenqt.stack_2021.models.ModelFollower
import com.keygenqt.stack_2021.models.ModelRepo
import com.keygenqt.stack_2021.utils.ConstantsPaging
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ViewModelHome @Inject constructor(
    private val dataRepo: DataRepo,
    private val repositoryRepo: RepositoryRepo,
    private val repositoryFollower: RepositoryFollower
) : LiveCoroutinesViewModel() {

    private val _selectedTab: MutableState<Int> = mutableStateOf(0)
    val selectedTab: State<Int> get() = _selectedTab

    private var _repoView: LiveData<ModelRepo> = MutableLiveData()
    val repoView: LiveData<ModelRepo> get() = _repoView

    val repos: Flow<PagingData<ModelRepo>> = Pager(PagingConfig(pageSize = ConstantsPaging.PER_PAGE)) {
        PageSourceRepo(repositoryRepo)
    }.flow.cachedIn(viewModelScope)

    val followers: Flow<PagingData<ModelFollower>> = Pager(PagingConfig(pageSize = ConstantsPaging.PER_PAGE)) {
        PageSourceFollower(repositoryFollower)
    }.flow.cachedIn(viewModelScope)

    @MainThread
    fun selectTab(@StringRes tab: Int) {
        _selectedTab.value = tab
    }

    @WorkerThread
    fun getRepo(id: Long) {
        _repoView = dataRepo.getModel(id)
    }
}
