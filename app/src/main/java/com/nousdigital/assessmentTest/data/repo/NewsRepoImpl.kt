package com.nousdigital.assessmentTest.data.repo

import com.nousdigital.assessmentTest.data.model.News
import com.nousdigital.assessmentTest.utilis.Connectivity

/*
 * Project Name : News
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :09-05-2020 
 * File Name : NewsRepoImpl.kt
 * ClassName : NewsRepoImpl
 * Module Name : app
 * Desc : RecipeRepositoryImpl Handle the Repository data
 * Response parsing from remote source
 */

class NewsRepoImpl(
    private val connectivity: Connectivity,
    private val repo: NewsRepo
) : NewsRepository {

    override suspend fun getNewsList(): Result<News> {
        return if (connectivity.isNetworkAvailable()) {
            getNewsData()
        } else return Result.Error("No Internet Connection")
    }

    private suspend fun getNewsData(): Result<News> {
        val response = repo.getNewsList()
        if (response.isSuccessful) {
            response.body()?.let {
                return Result.Success(it)
            }
        }
        return Result.Error(response.errorBody().toString())
    }
}
