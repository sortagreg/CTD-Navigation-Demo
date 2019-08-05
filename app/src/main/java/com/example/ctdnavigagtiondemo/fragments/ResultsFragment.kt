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


    val randomInt = Random.nextInt(1, 4)

    val aiChoice: String = when (randomInt) {

        1 -> "ROCK"
        2 -> "PAPER"
        3-> "SCISSORS"
        else -> "OK SOMETHING IS VERY VERY WRONG"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val userChoice: RPS = arguments?.get(getString(R.string.USER_CHOICE)) as RPS


        if (userChoice.name == "ROCK"){
            if (aiChoice == "PAPER"){
                textViewResult.text = "You Lose"
            }
            if (aiChoice == "SCISSORS"){
                textViewResult.text = "You Win"
            }
            if(aiChoice == "ROCK"){
                textViewResult.text = "You Tied"
            }
        }

        if (userChoice.name == "PAPER"){
            if (aiChoice == "SCISSORS"){
                textViewResult.text = "You Lose"
            }
            if (aiChoice == "ROCK"){
                textViewResult.text = "You Win"
            }
            if(aiChoice == "PAPER"){
                textViewResult.text = "You Tied"
            }
        }

        if (userChoice.name == "SCISSORS"){
            if (aiChoice == "ROCK"){
                textViewResult.text = "You Lose"
            }
            if (aiChoice == "PAPER"){
                textViewResult.text = "You Win"
            }
            if(aiChoice == "SCISSORS"){
                textViewResult.text = "You Tied"
            }
        }


        textViewAiChoice.text = aiChoice.toString()
        textViewPlayerChoice.text = userChoice.name
        buttonPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.action_global_startFragment)
        }
        painting.setOnClickListener {
            findNavController().navigate(R.id.action_resultsFragment_to_credits2)
        }

    }
}
