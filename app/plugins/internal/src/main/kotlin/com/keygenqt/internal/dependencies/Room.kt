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

object Room {
    /**
     * [Android Room Runtime](https://mvnrepository.com/artifact/androidx.room/room-runtime)
     */
    const val runtime = "androidx.room:room-runtime:${Versions.room}"

    /**
     * [Android Room Kotlin Extensions](https://mvnrepository.com/artifact/androidx.room/room-ktx)
     */
    const val ktx = "androidx.room:room-ktx:${Versions.room}"

    /**
     * [Android Room Compiler](https://mvnrepository.com/artifact/androidx.room/room-compiler)
     */
    const val compiler = "androidx.room:room-compiler:${Versions.room}"
}