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

import android.content.Context
import com.keygenqt.stack_2021.base.SharedPreferences
import com.keygenqt.stack_2021.data.followers.DaoFollower
import com.keygenqt.stack_2021.data.repos.DaoRepo
import com.keygenqt.stack_2021.data.repos.ServiceRepo
import com.keygenqt.stack_2021.data.repos.impl.RepositoryRepo
import com.keygenqt.stack_2021.data.user.ServiceUser
import com.keygenqt.stack_2021.data.user.impl.RepositoryUser
import com.keygenqt.stack_2021.data.followers.ServiceFollower
import com.keygenqt.stack_2021.data.followers.impl.RepositoryFollower
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRepositoryRepo(
        preferences: SharedPreferences,
        service: ServiceRepo,
        dao: DaoRepo
    ): RepositoryRepo {
        return RepositoryRepo(preferences, service, dao)
    }

    @Provides
    @ViewModelScoped
    fun provideRepositoryFollower(
        preferences: SharedPreferences,
        service: ServiceFollower,
        dao: DaoFollower
    ): RepositoryFollower {
        return RepositoryFollower(preferences, service, dao)
    }

    @Provides
    @ViewModelScoped
    fun provideRepositoryUser(
        @ApplicationContext context: Context,
        preferences: SharedPreferences,
        service: ServiceUser
    ): RepositoryUser {
        return RepositoryUser(preferences, service, context)
    }
}