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

import com.keygenqt.stack_2021.data.repos.impl.ResponseRepo
import com.keygenqt.stack_2021.models.ModelRepo

fun ResponseRepo.toModelRepo(page: Int): ModelRepo {
    return ModelRepo(
        id = this.id,
        name = this.name,
        language = this.language ?: "",
        createdAt = this.created_at,
        page = page,
    )
}

fun List<ResponseRepo>.toModelRepos(page: Int): List<ModelRepo> {
    return this.map { it.toModelRepo(page) }
}