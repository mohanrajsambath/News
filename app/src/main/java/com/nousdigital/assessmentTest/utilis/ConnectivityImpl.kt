package com.nousdigital.assessmentTest.utilis

import android.content.Context
import android.net.ConnectivityManager

/*
 * Project Name : News
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :12-05-2020 
 * File Name : ConnectivityImpl.kt
 * ClassName : ConnectivityImpl
 * Module Name : app
 * Desc : Check's the network Status
 * @return  Boolean status of the network connection
 */

@Suppress("DEPRECATION")
class ConnectivityImpl(private val context: Context) : Connectivity {
    override fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivityManager.activeNetworkInfo
        return info != null && info.isConnected
    }
}
interface Connectivity {
    fun isNetworkAvailable(): Boolean
}
