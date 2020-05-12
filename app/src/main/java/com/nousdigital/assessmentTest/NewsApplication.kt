package com.nousdigital.assessmentTest

import android.app.Application
import com.nousdigital.assessmentTest.di.NewsModule
import com.nousdigital.assessmentTest.di.networkModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/*
 * Project Name : News
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :10-05-2020
 * File Name : NewsApplication.kt
 * ClassName : NewsApplication
 * Module Name : app
 * Desc : NewsApplication class is base Class here
 * Global initialization that needs to be shared across
 * all components (crash reporting, di configure)
 */

class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    // Configure the dependency Injection
    private fun configureDi() {
        startKoin {
            androidLogger()
            androidContext(this@NewsApplication)
            modules(listOf(networkModel, NewsModule))
        }
    }
}
