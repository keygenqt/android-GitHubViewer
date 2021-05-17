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

object Lifecycle {

    /**
     * [Android Lifecycle Extensions](https://mvnrepository.com/artifact/androidx.lifecycle/lifecycle-extensions)
     */
    const val extensions =  "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

    /**
     * [Android Lifecycle Kotlin Extensions](https://mvnrepository.com/artifact/androidx.lifecycle/lifecycle-runtime-ktx)
     * Kotlin extensions for 'lifecycle' artifact
     */
    const val runtime =  "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    /**
     * [LiveData Kotlin Extensions](https://mvnrepository.com/artifact/androidx.lifecycle/lifecycle-livedata-ktx)
     * Kotlin extensions for 'livedata' artifact
     */
    const val livedata =  "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    /**
     * [Android Lifecycle ViewModel Kotlin Extensions](https://mvnrepository.com/artifact/androidx.lifecycle/lifecycle-viewmodel-ktx)
     * Kotlin extensions for 'viewmodel' artifact
     */
    const val viewmodel =  "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    /**
     * [Android Lifecycle Kotlin Extensions](https://mvnrepository.com/artifact/androidx.lifecycle/lifecycle-runtime-ktx)
     * Kotlin extensions for 'lifecycle' artifact
     */
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ktxLifecycleRuntime}"
}