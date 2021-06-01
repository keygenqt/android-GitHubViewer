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

package com.keygenqt.stack_2021.ui.other

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keygenqt.stack_2021.base.ResponseResult
import com.keygenqt.stack_2021.base.SharedPreferences
import com.keygenqt.stack_2021.data.user.impl.RepositoryUser
import com.keygenqt.stack_2021.extension.isSucceeded
import com.keygenqt.stack_2021.extension.runSucceeded
import com.keygenqt.stack_2021.models.ModelUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ViewModelSplash @Inject constructor(
    private val preferences: SharedPreferences,
    private val repository: RepositoryUser
) : ViewModel() {

    val loadingUser: Flow<ResponseResult<ModelUser>> = this.repository.loadingUser().onEach {
        it.runSucceeded { user ->
            preferences.modelUser = user
        }
        Timber.e("Loading user result: ${it.isSucceeded}")
    }

    fun repeat() {
        viewModelScope.launch {
            loadingUser.collect()
        }
    }
}
