///*
// * Copyright 2021 Vitaliy Zarubin
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.keygenqt.stack_2021.data.repos.paging
//
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.keygenqt.stack_2021.data.repos.impl.RepositoryRepo
//import com.keygenqt.stack_2021.extension.pagingSucceeded
//import com.keygenqt.stack_2021.models.ModelRepo
//
//
//class PageSourceRepo(
//    private val repository: RepositoryRepo
//) : PagingSource<Int, ModelRepo>() {
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ModelRepo> {
//        val page = params.key ?: 1
//        return repository.getModels(page).pagingSucceeded { data ->
//            LoadResult.Page(
//                data = data,
//                prevKey = if (page == 1) null else page - 1,
//                nextKey = if (data.isEmpty()) null else page.plus(1)
//            )
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, ModelRepo>): Int? {
//        return state.anchorPosition?.let { anchorPosition ->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
//        }
//    }
//}