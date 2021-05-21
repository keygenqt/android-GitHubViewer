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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import com.keygenqt.stack_2021.base.LiveCoroutinesViewModel
import com.keygenqt.stack_2021.models.ModelFollower
import com.keygenqt.stack_2021.models.ModelRepo
import com.keygenqt.stack_2021.repository.RepositoryFollower
import com.keygenqt.stack_2021.repository.RepositoryRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ViewModelHome @Inject constructor(
    private val repositoryRepo: RepositoryRepo,
    private val repositoryFollower: RepositoryFollower
) : LiveCoroutinesViewModel() {

    private var _listRepo: MutableLiveData<Boolean> = MutableLiveData(true)
    val listRepo: LiveData<List<ModelRepo>>

    private var _listFollower: MutableLiveData<Boolean> = MutableLiveData(true)
    val listFollower: LiveData<List<ModelFollower>>

    private val _selectedTab: MutableState<Int> = mutableStateOf(0)
    val selectedTab: State<Int> get() = _selectedTab

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {
        listRepo = _listRepo.switchMap {
            _isLoading.postValue(true)
            launchOnViewModelScope {
                this.repositoryRepo.loadRepos(
                    1,
                    onDone = { _isLoading.postValue(false) },
                    onError = { Timber.e(it) }
                ).asLiveData()
            }
        }
        listFollower = _listFollower.switchMap {
            _isLoading.postValue(true)
            launchOnViewModelScope {
                this.repositoryFollower.loadFollower(
                    1,
                    onDone = { _isLoading.postValue(false) },
                    onError = { Timber.e(it) }
                ).asLiveData()
            }
        }
    }

    @MainThread
    fun selectTab(@StringRes tab: Int) {
        _selectedTab.value = tab
    }
}
