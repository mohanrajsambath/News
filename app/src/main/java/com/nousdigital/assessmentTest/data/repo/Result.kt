package com.nousdigital.assessmentTest.data.repo

/*
 * Project Name : News
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :09-05-2020 
 * File Name : Result.kt
 * ClassName : Result
 * Module Name : app
 * Desc : Handle the Result success and Error data.
 */

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val data: String) : Result<Nothing>()
}
