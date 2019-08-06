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

        val userChoice: RPS = arguments?.get(getString(R.string.UserChoice)) as RPS
        textViewPlayerChoice.text = userChoice.name
        var gamenum = Random.nextInt(1,3)
        if(gamenum == 1)
        {
            var gameChoice = RPS.ROCK
            textViewAiChoice.text = gameChoice.name
            if (userChoice == RPS.ROCK){
                R.string.gameResult = "We Tied"
            }
            if(userChoice == RPS.PAPER){
                R.string.gameResult = "You Win"
            }
            if(userChoice == RPS.SCISSORS){
                R.string.gameResult = "I win"
            }
        }
        if(gamenum == 2)
        {
            var gameChoice = RPS.PAPER
            textViewAiChoice.text = gameChoice.name
            if (userChoice == RPS.ROCK){
                R.string.gameResult = "I win!"
            }
            if(userChoice == RPS.PAPER){
                R.string.gameResult = "We Tied!"
            }
            if(userChoice == RPS.SCISSORS){
                R.string.gameResult = "You win!"
            }
        }
        if(gamenum == 3)
        {
            var gameChoice = RPS.SCISSORS
            textViewAiChoice.text = gameChoice.name
            if (userChoice == RPS.ROCK){
                R.string.gameResult = "You Win!"
            }
            if(userChoice == RPS.PAPER){
                R.string.gameResult = "I Win!"
            }
            if(userChoice == RPS.SCISSORS){
                R.string.gameResult = "We Tied!"
            }
        }





        PaintingTransfer.setOnClickListener{
            findNavController().navigate(R.id.action_resultsFragment_to_creditsFragment)
        }


    }



}
