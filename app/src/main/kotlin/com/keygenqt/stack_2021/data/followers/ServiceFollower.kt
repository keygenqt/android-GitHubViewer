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
 
package com.keygenqt.stack_2021.data.followers

import androidx.annotation.IntRange
import com.keygenqt.stack_2021.data.followers.impl.ResponseFollower
import com.keygenqt.stack_2021.utils.ConstantsPaging
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ServiceFollower {
    @GET
    suspend fun listFollowers(
        @Url reposUrl: String,
        @Query("page") @IntRange(from = 1) page: Int = 1,
        @Query("per_page") @IntRange(from = 1, to = ConstantsPaging.MAX_PAGE_SIZE.toLong()) perPage: Int = ConstantsPaging.PER_PAGE,
        @Query("sort") sort: String = "created"
    ): Response<List<ResponseFollower>>
}
