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

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import com.keygenqt.stack_2021.R
import com.keygenqt.stack_2021.base.LiveCoroutinesViewModel
import com.keygenqt.stack_2021.models.ModelUser
import com.keygenqt.stack_2021.repository.RepositoryUser
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ViewModelSplash @Inject constructor(
    @ApplicationContext context: Context,
    private val repository: RepositoryUser
) : LiveCoroutinesViewModel() {

    private val _isLoadingUser: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoadingUser: LiveData<Boolean>

    init {
        isLoadingUser = _isLoadingUser.switchMap {
            launchOnViewModelScope {
                this.repository.loadUser(
                    context.getString(R.string.github_user),
                    onDone = {  },
                    onError = { Timber.e(it) }
                ).asLiveData()
            }
        }
    }
}
