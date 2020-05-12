package com.nousdigital.assessmentTest.views.news_details

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.nousdigital.assessmentTest.databinding.FragmentNewsDetailsBinding

/*
 * Project Name : News
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :09-05-2020 
 * File Name : NewsDetailViewModel.kt
 * ClassName : NewsDetailViewModel
 * Module Name : app
 * Desc : NewsDetailsFragment class
 *  show the detailed view of  Image, Tittle and
 *  Description.
 */

class NewsDetailsFragment : Fragment() {
    private lateinit var binding: FragmentNewsDetailsBinding
    private val args: NewsDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsDetailsBinding.inflate(inflater, container, false)
        binding.item = args.item
        binding.executePendingBindings()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onBackPressed()
        onClick()
    }

    private fun onBackPressed() {
        binding.toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun onClick() {
        binding.clickListener = View.OnClickListener {
            val attachment = args.item.title + "\n" + args.item.description + "\n" + args.item.imageUrl
            try {
                val emailIntent = Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, attachment)
                }
                emailIntent.type = "text/plain"
                this.startActivity(Intent.createChooser(emailIntent, "Sending email..."))
            } catch (t: Throwable) {
                Toast.makeText(requireContext(), "Request failed try again: $t", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}
