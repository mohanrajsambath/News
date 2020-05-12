package com.nousdigital.assessmentTest.views.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nousdigital.assessmentTest.data.model.Item
import com.nousdigital.assessmentTest.data.repo.NewsRepository
import com.nousdigital.assessmentTest.data.repo.Result
import com.nousdigital.assessmentTest.utilis.BaseViewModel
import kotlinx.coroutines.launch

/*
 * Project Name : News
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on : 09-05-2020
 * File Name : NewsViewModel.kt
 * ClassName : NewsViewModel
 * Module Name : app
 * Desc : NewsViewModel Handle
 *  load data from repository
 *  update the data to View through LiveData
 */

class NewsViewModel(private val repo: NewsRepository) : BaseViewModel() {

    private var newsItem: MutableLiveData<List<Item>> = MutableLiveData()
    fun newsData() = newsItem

    /**
     * Web service Invoking
     */
    init {
        loadNewsList()
    }

    /**
     *Handling the Api request
     */
    private fun loadNewsList() {
        viewModelScope.launch {
            when (val result = repo.getNewsList()) {
                is Result.Success -> {
                    newsItem.value = result.data.items
                }
                is Result.Error -> {
                    errorMessage.postValue(result.data)
                }
            }
            isLoading.set(false)
        }
    }
}
