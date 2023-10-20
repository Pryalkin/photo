package com.bsuir.photography.app.repository

import com.bsuir.photography.app.model.*
import com.bsuir.photography.sources.exception.BackendException
import com.bsuir.photography.sources.exception.InvalidCredentialsException
import com.bsuir.photography.sources.model.AppSource
import retrofit2.Response

class AppRepository(
    private val appSource: AppSource
) {


    suspend fun search(): Response<Search> {
        val res: Response<Search> = try {
            appSource.search()
        } catch (e: Exception) {
            if (e is BackendException && e.code == 401) {
                // map 401 error for sign-in to InvalidCredentialsException
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }
        }
        return res
    }

    suspend fun getData(id: String): Response<W> {
        val res: Response<W> = try {
            appSource.getData(id)
        } catch (e: Exception) {
            if (e is BackendException && e.code == 401) {
                // map 401 error for sign-in to InvalidCredentialsException
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }
        }
        return res
    }


}