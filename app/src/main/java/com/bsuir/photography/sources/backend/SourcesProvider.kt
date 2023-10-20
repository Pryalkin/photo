package com.bsuir.photography.sources.backend

import com.bsuir.photography.sources.model.AppSource

interface SourcesProvider {

    fun getAppSource(): AppSource

}