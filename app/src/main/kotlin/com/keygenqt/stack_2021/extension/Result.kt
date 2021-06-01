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
 
package com.keygenqt.stack_2021.extension

import androidx.paging.PagingSource
import com.keygenqt.stack_2021.base.NotFoundException
import com.keygenqt.stack_2021.base.ResponseResult

val ResponseResult<*>?.isSucceeded get() = this != null && this is ResponseResult.Success && data != null

val ResponseResult<*>?.isError get() = this != null && this is ResponseResult.Error

inline infix fun <T, Value : Any> ResponseResult<T>?.runSucceeded(predicate: (data: T) -> Value): Value? {
    if (this != null && this.isSucceeded && this is ResponseResult.Success && this.data != null) {
        return predicate.invoke(this.data)
    }
    return null
}

inline infix fun <T> ResponseResult<T>.success(predicate: (data: T) -> Unit): ResponseResult<T> {
    if (this is ResponseResult.Success && this.data != null) {
        predicate.invoke(this.data)
    }
    return this
}

inline infix fun <T> ResponseResult<T>.error(predicate: (data: Exception) -> Unit) {
    if (this is ResponseResult.Error) {
        predicate.invoke(this.exception)
    }
}

inline infix fun <T, Value : Any> ResponseResult<T>.pagingSucceeded(
    predicate: (data: T) -> PagingSource.LoadResult<Int, Value>
): PagingSource.LoadResult<Int, Value> {
    return if (this is ResponseResult.Success && this.data != null) {
        predicate.invoke(this.data)
    } else {
        if (this is ResponseResult.Error) {
            PagingSource.LoadResult.Error(this.exception)
        } else {
            PagingSource.LoadResult.Error(NotFoundException())
        }
    }
}