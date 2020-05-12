package com.nousdigital.assessmentTest.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nousdigital.assessmentTest.R

/*
* Project Name : News
* Created by : R Sathish Kumar - Android Application Developer
* Created on :10-05-2020
* File Name : MainActivity.kt
* ClassName : MainActivity
* Module Name : app
* Desc :  MainActivity.kt class is Single Activity
* load UI screen.
*/

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
