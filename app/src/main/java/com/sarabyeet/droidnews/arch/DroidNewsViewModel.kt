package com.sarabyeet.droidnews.arch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sarabyeet.droidnews.arch.DroidNewsRepository
import com.sarabyeet.droidnews.model.DroidNewsItem

class DroidNewsViewModel : ViewModel() {

    private val repository = DroidNewsRepository()

    private val _droidNewsLiveData = MutableLiveData<List<DroidNewsItem>>()
    val droidNewsLiveData: LiveData<List<DroidNewsItem>> = _droidNewsLiveData

    fun fetchNews() {
        repository.fetchNews(_droidNewsLiveData)
    }

    fun updateFavoriteStatus(id: String, isFavorite: Boolean) {
        repository.updateFavoriteStatus(id, isFavorite)
    }
}