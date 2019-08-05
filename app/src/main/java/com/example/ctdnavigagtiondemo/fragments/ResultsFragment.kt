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


class ResultsFragment : Fragment()  {

    val x = listOf("ROCK", "PAPER", "SCISSORS")
    val y = x.shuffled().take(1)[0]




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
        val userChoice: RPS = arguments?.get("user_choice") as RPS

        textViewPlayerChoice.text = userChoice.name

        val aiChoice: String = y

        textViewAiChoice.text = aiChoice

        buttonCredits.setOnClickListener {
            findNavController().navigate(R.id.action_resultsFragment_to_creditsFragment)
        }
        textViewResult.text = if (userChoice.name == "ROCK" && aiChoice == "SCISSORS" ||
            userChoice.name == "SCISSORS" && aiChoice == "PAPER" ||
            userChoice.name == "PAPER" && aiChoice == "ROCK"
        ) {
            "You Win"
        } else {
            "You Lose"
        }


    }


}
