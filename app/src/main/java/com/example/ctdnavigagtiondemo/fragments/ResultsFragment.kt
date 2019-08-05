package com.example.ctdnavigagtiondemo.fragments

import kotlin.random.Random
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ctdnavigagtiondemo.R
import com.example.ctdnavigagtiondemo.models.AIRPS
import com.example.ctdnavigagtiondemo.models.RPS
import kotlinx.android.synthetic.main.fragment_results.*


class ResultsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(
            R.layout.fragment_results, container, false
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        buttonPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.action_global_startFragment)
        }

        //val userChoice: RPS = arguments?.get(getString(R.string.UserChoice)) as RPS
        //textViewPlayerChoice.text = userChoice.name

        //val AIChoice: RPS = arguments?.get(getString(R.string.AIChoice)) as RPS
        //textViewAiChoice.text = AIChoice.name

        PaintingTransfer.setOnClickListener{
            findNavController().navigate(R.id.action_resultsFragment_to_creditsFragment)
        }


    }
    fun messagePrint(){

    }

}
