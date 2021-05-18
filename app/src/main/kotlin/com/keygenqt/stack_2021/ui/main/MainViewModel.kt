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
 
package com.keygenqt.stack_2021.ui.main

import android.content.*
import androidx.annotation.*
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.keygenqt.stack_2021.R
import com.keygenqt.stack_2021.base.*
import com.keygenqt.stack_2021.data.models.*
import com.keygenqt.stack_2021.repository.*
import dagger.hilt.android.lifecycle.*
import dagger.hilt.android.qualifiers.*
import timber.log.*
import javax.inject.*

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val mainRepository: MainRepository
) : BaseLiveCoroutinesViewModel() {

    private var _link: MutableLiveData<String> = MutableLiveData("")
    val link: LiveData<String>

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _selectedTab: MutableState<Int> = mutableStateOf(0)
    val selectedTab: State<Int> get() = _selectedTab

    init {
        link = _link.switchMap {
            _isLoading.postValue(true)
            launchOnViewModelScope {
                this.mainRepository.loadRepoUrl(
                    context.getString(R.string.github_user),
                    onSuccess = { _isLoading.postValue(false) },
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
