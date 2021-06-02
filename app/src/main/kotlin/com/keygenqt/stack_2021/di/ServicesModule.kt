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

import com.keygenqt.stack_2021.data.followers.ServiceFollower
import com.keygenqt.stack_2021.data.repos.ServiceRepo
import com.keygenqt.stack_2021.data.user.ServiceUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServicesModule {

    @Provides
    @Singleton
    fun provideServiceUser(retrofit: Retrofit): ServiceUser {
        return retrofit.create(ServiceUser::class.java)
    }

    @Provides
    @Singleton
    fun provideServiceFollower(retrofit: Retrofit): ServiceFollower {
        return retrofit.create(ServiceFollower::class.java)
    }

    @Provides
    @Singleton
    fun provideServiceRepo(retrofit: Retrofit): ServiceRepo {
        return retrofit.create(ServiceRepo::class.java)
    }
}
