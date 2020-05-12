package com.nousdigital.assessmentTest.data.repo

import com.nousdigital.assessmentTest.data.model.News

/*
 * Project Name : News
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :09-05-2020 
 * File Name : NewsRepository.kt
 * ClassName : NewsRepository
 * Module Name : app
 * Desc : NewsRepository
 */

interface NewsRepository {
    suspend fun getNewsList(): Result<News>
}
