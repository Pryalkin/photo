package com.bsuir.photography.sources.model

import com.bsuir.photography.app.model.Data
import com.bsuir.photography.app.model.Search
import com.bsuir.photography.app.model.W
import retrofit2.Response

interface AppSource {
    suspend fun search(): Response<Search>
    suspend fun getData(id: String): Response<W>
}