package com.bsuir.photography.sources.backend

import com.bsuir.photography.sources.model.AppSource
import com.bsuir.photography.sources.model.RetrofitAppSource

class RetrofitSourcesProvider(
    private val config: RetrofitConfig
) : SourcesProvider {

    override fun getAppSource(): AppSource {
        return RetrofitAppSource(config)
    }

}