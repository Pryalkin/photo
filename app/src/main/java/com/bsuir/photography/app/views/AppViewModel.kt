package com.bsuir.photography.app.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsuir.photography.Singletons
import com.bsuir.photography.app.model.*
import com.bsuir.photography.app.model.utils.HttpResponse
import com.bsuir.photography.app.repository.AppRepository
import com.bsuir.photography.app.utils.MutableLiveEvent
import com.bsuir.photography.app.utils.publishEvent
import com.bsuir.photography.app.utils.share
import com.google.gson.GsonBuilder
import kotlinx.coroutines.launch
import retrofit2.Response

class AppViewModel  (
    private val appRepository: AppRepository = Singletons.appRepository
): ViewModel() {

    private val _message = MutableLiveEvent<String>()
    val message = _message.share()

    private val _search = MutableLiveData<Search>()
    val search: LiveData<Search> get() = _search

    private val _w = MutableLiveData<W>()
    val w: LiveData<W> get() = _w

    private fun showToast(mes: String) = _message.publishEvent(mes)

    fun search() {
        viewModelScope.launch {
            var res: Response<Search> = appRepository.search()
            if (res.isSuccessful){
                _search.value = res.body()
            } else {
                val gson = GsonBuilder().setDateFormat("MM-dd-yyyy hh:mm:ss").create()
                val mes = gson.fromJson(res.errorBody()!!.string(), HttpResponse::class.java).message
                showToast(mes)
            }
        }
    }

    fun getData(id: String) {
        viewModelScope.launch {
            var res: Response<W> = appRepository.getData(id)
            if (res.isSuccessful){
                _w.value = res.body()
            } else {
                val gson = GsonBuilder().setDateFormat("MM-dd-yyyy hh:mm:ss").create()
                val mes = gson.fromJson(res.errorBody()!!.string(), HttpResponse::class.java).message
                showToast(mes)
            }
        }
    }

}