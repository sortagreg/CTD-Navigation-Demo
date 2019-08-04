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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val userChoice: RPS = arguments?.get("user_choice") as RPS
        textViewPlayerChoice.text = userChoice.name
        val playerNum = when (userChoice.name) {
            "ROCK" -> 0
            "PAPER" -> 1
            else -> 2
        }
        val computer = Random.nextInt(0, 2)
        textViewAiChoice.text = when(computer) {
            0 -> "ROCK"
            1 -> "PAPER"
            else -> "SCISSORS"
        }

        textViewResult.text = when ((computer + 3 - playerNum) % 3) {
            0 -> "You tied."
            1 -> "You lost..."
            2 -> "You won!"
            else -> "how did you get here?"
        }

        buttonPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.action_global_startFragment)
        }
        buttonCredits.setOnClickListener{
            findNavController().navigate(R.id.action_resultsFragment_to_creditsFragment)
        }
    }
}
