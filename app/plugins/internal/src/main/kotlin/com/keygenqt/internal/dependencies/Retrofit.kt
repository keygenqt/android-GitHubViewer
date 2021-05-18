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
 
@file:Suppress("unused")

package com.keygenqt.internal.dependencies

import com.keygenqt.internal.*

object Retrofit {
    /**
     * [Converter: Gson](https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-gson)
     * A Retrofit Converter which uses Gson for serialization.
     */
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2}"

    /**
     * [Retrofit](https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit)
     * A type-safe HTTP client for Android and Java.
     */
    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"

    /**
     * [OkHttp Logging Interceptor](https://mvnrepository.com/artifact/com.squareup.okhttp3/logging-interceptor)
     * Square’s meticulous HTTP client for Java and Kotlin.
     */
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
}