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
        val userChoice: RPS = arguments?.get(getString(R.string.USER_CHOICE)) as RPS
        val aiChoice = RPS.values().random()
        val result = playGame(userChoice, aiChoice)

        textViewPlayerChoice.text = userChoice.name
        textViewAiChoice.text = aiChoice.name
        textViewResult.text = result


        buttonPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.action_global_startFragment)
        }
        buttonFinish.setOnClickListener {
            findNavController().navigate(R.id.action_resultsFragment4_to_creditsFragment)
        }
    }

    private fun playGame(userChoice: RPS, aiChoice: RPS): String {
        return when (userChoice) {
            aiChoice -> "You tied!"
            RPS.ROCK -> if (aiChoice == RPS.PAPER) "You lose!" else "You won!"
            RPS.PAPER -> if (aiChoice == RPS.SCISSORS) "You lose!" else "You won!"
            RPS.SCISSORS -> if (aiChoice == RPS.ROCK) "You lose!" else "You won!"
        }

    }

}
