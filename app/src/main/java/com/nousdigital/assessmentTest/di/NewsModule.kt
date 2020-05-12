package com.nousdigital.assessmentTest.di

import com.nousdigital.assessmentTest.views.news.NewsAdapter
import com.nousdigital.assessmentTest.views.news.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/*
 * Project Name : News
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :10-05-2020 
 * File Name : NewsModule.kt
 * ClassName : NewsModule
 * Module Name : app
 * Desc :  NewsModule provide di
 *  Adapter class and ViewModel
 */

val NewsModule = module {
    viewModel { NewsViewModel(get()) }
    factory { NewsAdapter() }
}
