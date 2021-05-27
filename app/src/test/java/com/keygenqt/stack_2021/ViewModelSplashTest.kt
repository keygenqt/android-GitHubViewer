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
 
package com.keygenqt.stack_2021

import com.keygenqt.stack_2021.base.NotFoundException
import com.keygenqt.stack_2021.base.ResponseResult
import com.keygenqt.stack_2021.data.user.impl.RepositoryUser
import kotlinx.coroutines.flow.single
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesNetworkDataSourceTest : ApiAbstract() {

    @Test
    fun `should fetch user with correctly 200 response`() {
        runBlockingApi("ResponseUser.json", 200) {
            // Arrange
            val sut = RepositoryUser(api, "keygenqt")
            // Act
            val response = sut.observeModel().single()
            // Assert
            assert(response is ResponseResult.Success)
            assertEquals((response as ResponseResult.Success).data.login, "keygenqt")
        }
    }

    @Test
    fun `should fetch user with error 404 response`() {
        runBlockingApi("ResponseUserError.json", 404) {
            // Arrange
            val sut = RepositoryUser(api, "keygenqt")
            // Act
            val response = sut.observeModel().single()
            // Assert
            assertEquals(response::class, ResponseResult.Error::class)
            assertEquals((response as ResponseResult.Error).exception::class, NotFoundException::class)
        }
    }
}