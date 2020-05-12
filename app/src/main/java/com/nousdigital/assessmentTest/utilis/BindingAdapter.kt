package com.nousdigital.assessmentTest.utilis

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.nousdigital.assessmentTest.R

/*
 * Project Name : News
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :10-05-2020 
 * File Name : BindingAdapter.kt
 * ClassName : BindingAdapter
 * Module Name : app
 * Desc : ViewBindingAdapter is to  set the attribute in XML
 * and data binding library will look for the binding adapter to
 * set that property to your view.
 */

@BindingAdapter("image")
fun setImageUrl(view: ImageView, imageURL: String?) {
    if (!imageURL.isNullOrEmpty()) {
        Glide.with(view.context).load(imageURL)
            .placeholder(R.drawable.preview)
            .into(view)
    }
}
