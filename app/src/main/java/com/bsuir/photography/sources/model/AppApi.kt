package com.bsuir.photography.sources.model

import androidx.compose.ui.unit.Constraints
import com.bsuir.photography.BuildConfig
import com.bsuir.photography.Constants
import com.bsuir.photography.app.model.Data
import com.bsuir.photography.app.model.Search
import com.bsuir.photography.app.model.W
import retrofit2.Response
import retrofit2.http.*

interface AppApi {

    @GET("w/{id}")
    suspend fun getData(@Path("id") id: String,
                        @Query("api_key") apiKey: String = Constants.API_KEY): Response<W>

    @GET("search")
    suspend fun search(@Query("api_key") apiKey: String = Constants.API_KEY): Response<Search>

}