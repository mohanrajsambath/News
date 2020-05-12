package com.nousdigital.assessmentTest.di

import com.nousdigital.assessmentTest.BuildConfig
import com.nousdigital.assessmentTest.data.repo.NewsRepo
import com.nousdigital.assessmentTest.data.repo.NewsRepoImpl
import com.nousdigital.assessmentTest.data.repo.NewsRepository
import com.nousdigital.assessmentTest.utilis.Connectivity
import com.nousdigital.assessmentTest.utilis.ConnectivityImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
 * Project Name : News
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :09-05-2020 
 * File Name : RemoteModule.kt
 * ClassName : RemoteModule
 * Module Name : app
 * Desc : Configure  the di for
 *   Retrofit, okHttpClient,provideNewsService
 *  to make web service.
 */

val networkModel = module {
    single { provideRetrofit(get()) }
    single { provideNewsService(get()) }
    factory { okHttpClient() }
    single { ConnectivityImpl(androidContext()) }.bind(Connectivity::class)
    single { NewsRepoImpl(get(), get()) }.bind(NewsRepository::class)
}

/**
 * Configure Retrofit with BaseURL
 */
fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

/**
 * Configure OkHttpClient to make network request
 */
fun okHttpClient(): OkHttpClient {
    val interceptor: HttpLoggingInterceptor? = HttpLoggingInterceptor()
    interceptor!!.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
}

/**
 * Provide Instance to NewsRepo
 */
fun provideNewsService(retrofit: Retrofit): NewsRepo =
    retrofit.create(NewsRepo::class.java)
