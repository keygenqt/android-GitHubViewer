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

package com.keygenqt.stack_2021.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.keygenqt.stack_2021.models.ModelRepo
import com.keygenqt.stack_2021.repository.RepositoryRepo
import kotlinx.coroutines.delay
import timber.log.Timber

class PageSourceRepo(
    private val repository: RepositoryRepo
) : PagingSource<Int, ModelRepo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ModelRepo> {
        return try {
            val page = params.key ?: 1
            val response = repository.loadRepos2(page)

            Timber.e("Page load: $page")

            LoadResult.Page(
                data = response.results,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.results.isEmpty()) null else response.page.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ModelRepo>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}