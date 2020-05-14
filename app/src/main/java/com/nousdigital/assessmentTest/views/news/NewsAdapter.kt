package com.nousdigital.assessmentTest.views.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.nousdigital.assessmentTest.data.model.Item
import com.nousdigital.assessmentTest.databinding.NewsItemBinding

/*
 * Project Name : News
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on : 09-05-2020
 * File Name : NewsAdapter.kt
 * ClassName : NewsAdapter
 * Module Name : app
 * Desc : RecipeItemRecyclerViewAdapter class for the bind the value into
 * Bindview Holder using into UI
 */

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private var items: MutableList<Item> = mutableListOf()

    // Casting the views in onCreateViewHolder using DataBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: NewsItemBinding =
            NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    /**
     * updating data to adapter
     */
    fun update(data: List<Item>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.itemDetails = item
            binding.executePendingBindings()

            // triggering Onclick Listenter
            binding.clickListener = View.OnClickListener {
                val destination = NewsFragmentDirections.actionNews(item)
                it?.findNavController()?.navigate(destination)
            }
        }


    }
}
