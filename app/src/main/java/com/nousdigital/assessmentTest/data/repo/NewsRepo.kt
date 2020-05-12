package com.nousdigital.assessmentTest.data.repo

import com.nousdigital.assessmentTest.data.endpointpath.EndPointsPath
import com.nousdigital.assessmentTest.data.model.News
import retrofit2.Response
import retrofit2.http.GET

/*
 * Project Name : News
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :09-05-2020 
 * File Name : NewsRepo.kt
 * ClassName : NewsRepo
 * Module Name : app
 * Desc : Service Interface class
 */

interface NewsRepo {
    @GET(EndPointsPath.News.NewsGeneral)
    suspend fun getNewsList(): Response<News>
}
