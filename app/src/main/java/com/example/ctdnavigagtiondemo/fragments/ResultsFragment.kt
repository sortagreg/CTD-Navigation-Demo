package com.example.ctdnavigagtiondemo.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ctdnavigagtiondemo.R
import com.example.ctdnavigagtiondemo.models.RPS
import kotlinx.android.synthetic.main.fragment_results.*
import kotlinx.android.synthetic.main.fragment_start.*
import kotlin.random.Random


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
        val userChoice: RPS = arguments?.get(getString(R.string.USERCHOICE)) as RPS

        textViewPlayerChoice.text = userChoice.name

        var aiChoice = RPS.PAPER
        val aiInput = Random.nextInt(1, 3)
        if (aiInput == 1) aiChoice = RPS.PAPER else if (aiInput == 2) aiChoice = RPS.ROCK else aiChoice = RPS.SCISSORS

        textViewAiChoice.text = aiChoice.name


        when {
            userChoice == RPS.PAPER -> if (aiChoice == RPS.SCISSORS) textViewResult.text = "You Lost!" else if (aiChoice == userChoice) {textViewResult.text = "You Tied!"} else textViewResult.text = "You Won!"
            userChoice == RPS.SCISSORS -> if (aiChoice == RPS.ROCK) textViewResult.text = "You Lost!" else if (aiChoice == userChoice) {textViewResult.text = "You Tied!"} else textViewResult.text = "You Won!"
            userChoice == RPS.ROCK -> if (aiChoice == RPS.PAPER) textViewResult.text = "You Lost!" else if (aiChoice == userChoice) {textViewResult.text = "You Tied!"} else textViewResult.text = "You Won!"
        }
        buttonPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.action_global_startFragment)
        }
        picturebutton.setOnClickListener{
            findNavController().navigate(R.id.action_resultsFragment_to_creditsFragment)
        }
    }
}
