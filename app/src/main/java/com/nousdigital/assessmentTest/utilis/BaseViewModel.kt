package com.nousdigital.assessmentTest.utilis

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*
 * Project Name : News
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :09-05-2020 
 * File Name : BaseViewModel.kt
 * ClassName : BaseViewModel
 * Module Name : app
 * Desc : BaseViewModel is inherit from ViewModel.
 *  BaseViewModel create  for Error Handling message,
 *  Loader indicator purpose
 */

abstract class BaseViewModel : ViewModel() {

    // ERROR message
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    // Loading indicator
    val isLoading = ObservableField(true)
}
