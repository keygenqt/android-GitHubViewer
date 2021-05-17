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
 
package com.keygenqt.stack_2021.di

import android.content.*
import androidx.security.crypto.*
import com.keygenqt.stack_2021.base.*
import dagger.*
import dagger.hilt.*
import dagger.hilt.android.components.*
import dagger.hilt.android.qualifiers.*
import dagger.hilt.android.scopes.*

@Module
@InstallIn(ViewModelComponent::class)
object CommonModule {
    @Provides
    @ViewModelScoped
    fun provideBaseSharedPreferences(@ApplicationContext context: Context): BaseSharedPreferences {
        return BaseSharedPreferences(
            EncryptedSharedPreferences.create(
                context,
                "sharedPrefsFile",
                MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        )
    }
}
