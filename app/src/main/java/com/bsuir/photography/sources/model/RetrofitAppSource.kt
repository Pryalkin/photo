package com.bsuir.photography.sources.model

import com.bsuir.photography.app.model.Data
import com.bsuir.photography.app.model.Search
import com.bsuir.photography.app.model.W
import com.bsuir.photography.sources.backend.BackendRetrofitSource
import com.bsuir.photography.sources.backend.RetrofitConfig
import kotlinx.coroutines.delay
import retrofit2.Response

class RetrofitAppSource(
    config: RetrofitConfig
) : BackendRetrofitSource(config), AppSource {

    private val appApi = retrofit.create(AppApi::class.java)

    override suspend fun search(): Response<Search> = wrapRetrofitExceptions {
        delay(1000)
        appApi.search()
    }

    override suspend fun getData(id: String): Response<W> = wrapRetrofitExceptions {
        delay(1000)
        appApi.getData(id)
    }


}