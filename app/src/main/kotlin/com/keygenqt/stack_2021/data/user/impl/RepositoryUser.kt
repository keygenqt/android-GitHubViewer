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
 
package com.keygenqt.stack_2021.data.user.impl

import android.content.Context
import androidx.annotation.WorkerThread
import com.keygenqt.stack_2021.R
import com.keygenqt.stack_2021.base.ResponseResult
import com.keygenqt.stack_2021.base.SharedPreferences
import com.keygenqt.stack_2021.data.user.ServiceUser
import com.keygenqt.stack_2021.data.user.UserRepository
import com.keygenqt.stack_2021.extension.toModelUser
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryUser @Inject constructor(
    private val preferences: SharedPreferences,
    private val service: ServiceUser,
    private val context: Context
) : UserRepository {

    @WorkerThread
    override fun observeModel() = flow {
        try {
            service.getUser(context.getString(R.string.github_user)).body()?.toModelUser()?.let { model ->
                preferences.modelUser = model
                emit(ResponseResult.Success(preferences.modelUser!!))
            }
        } catch (ex: Exception) {
            emit(ResponseResult.Error(ex))
        }
    }
}
