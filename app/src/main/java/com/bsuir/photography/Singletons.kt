package com.bsuir.photography

import android.content.Context
import com.bsuir.photography.app.repository.AppRepository
import com.bsuir.photography.app.setting.AppSettings
import com.bsuir.photography.app.setting.SharedPreferencesAppSettings
import com.bsuir.photography.sources.SourceProviderHolder
import com.bsuir.photography.sources.backend.SourcesProvider
import com.bsuir.photography.sources.model.AppSource
import com.bsuir.photography.app.views.AppViewModel


object Singletons {

    private lateinit var appContext: Context

    private val sourcesProvider: SourcesProvider by lazy {
        SourceProviderHolder.sourcesProvider
    }

    val appSettings: AppSettings by lazy {
        SharedPreferencesAppSettings(appContext)
    }

    // source
    private val appSource: AppSource by lazy {
        sourcesProvider.getAppSource()
    }

    // repository
    val appRepository: AppRepository by lazy {
        AppRepository(
            appSource = appSource
        )
    }

    // viewModel

    val appViewModel: AppViewModel by lazy {
        AppViewModel()
    }

    fun init(appContext: Context) {
        Singletons.appContext = appContext
    }

}