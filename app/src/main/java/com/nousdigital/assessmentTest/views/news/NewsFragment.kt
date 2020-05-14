package com.nousdigital.assessmentTest.views.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.nousdigital.assessmentTest.databinding.FragmentNewsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/*
 * Project Name : News
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on : 09-05-2020
 * File Name : NewsFragment.kt
 * ClassName : NewsFragment
 * Module Name : app
 * Desc : NewsFragment class  handle the UI part
 * loaded the map the data into RecyclerView
 */

class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    private val newsViewModel: NewsViewModel by viewModel()
    private val newsAdapter: NewsAdapter = NewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        setUpViewModelObserver()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = newsViewModel
        binding.adapter = newsAdapter
    }

    private fun setUpViewModelObserver() {

        // adds the new set of results to the adapter list
        newsViewModel.newsData().observe(viewLifecycleOwner, Observer {
            newsAdapter.update(it)
        })

        /**
         * displaying error status from viewModel communicate via Observer
         * display the error message
         */
        newsViewModel.errorMessage.observe(
            viewLifecycleOwner,
            Observer {
                Toast.makeText(this.requireActivity(), it, Toast.LENGTH_SHORT).show()
            }
        )
    }
}
