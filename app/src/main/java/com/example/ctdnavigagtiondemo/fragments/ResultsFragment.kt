package com.example.ctdnavigagtiondemo.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ctdnavigagtiondemo.R
import com.example.ctdnavigagtiondemo.databinding.FragmentResultsBinding


class ResultsFragment : Fragment() {

    private lateinit var binding: FragmentResultsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_results, container, false
        )

        binding.buttonPlayAgain.setOnClickListener {

        }

//        binding.textViewResult.text =
//        binding.textViewPlayerChoice.text =
//        binding.textViewAiChoice.text =

        return binding.root
    }
}
