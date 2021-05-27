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

import com.keygenqt.stack_2021.data.user.ServiceUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.StandardCharsets
import java.util.concurrent.TimeUnit

@RunWith(JUnit4::class)
abstract class ApiAbstract {

    private val mockWebServer = MockWebServer()

    private val client = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.SECONDS)
        .readTimeout(1, TimeUnit.SECONDS)
        .writeTimeout(1, TimeUnit.SECONDS)
        .build()

    val api = Retrofit.Builder()
        .baseUrl(mockWebServer.url("/"))
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ServiceUser::class.java)

    private fun MockWebServer.enqueueResponse1(fileName: String, code: Int) {
        javaClass.classLoader?.getResourceAsStream("api-response/$fileName")?.source()?.buffer()?.let {
            enqueue(
                MockResponse()
                    .setResponseCode(code)
                    .setBody(it.readString(StandardCharsets.UTF_8))
            )
        }
    }

    fun <T> runBlockingApi(fileName: String, code: Int, block: suspend CoroutineScope.() -> T) {
        mockWebServer.enqueueResponse1(fileName = fileName, code = code)
        runBlocking {
            block.invoke(this)
        }
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}
