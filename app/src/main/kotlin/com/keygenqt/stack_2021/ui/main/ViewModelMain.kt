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

import android.os.Handler
import android.os.Looper
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.keygenqt.stack_2021.base.LiveCoroutinesViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelMain @Inject constructor() : LiveCoroutinesViewModel() {

    private val _showSnackBar: MutableLiveData<Boolean> = MutableLiveData(false)
    val showSnackBar: LiveData<Boolean> get() = _showSnackBar

    @MainThread
    fun isShowSnackBar(): Boolean {
        return _showSnackBar.value ?: false
    }

    @MainThread
    fun toggleSnackBar() {
        _showSnackBar.postValue(true)
        Handler(Looper.getMainLooper()).postDelayed({
            _showSnackBar.postValue(false)
        }, 1500)
    }
}
