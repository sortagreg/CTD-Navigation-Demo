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
        val result = findResult(userChoice, aiChoice)

        textViewPlayerChoice.text = userChoice.name
        textViewAiChoice.text = aiChoice.name
        textViewResult.text = result

        buttonPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.action_global_startFragment)
        }
        buttonPainting.setOnClickListener {
            findNavController().navigate(R.id.action_resultsFragment_to_paintingFragment)
        }
    }

    private fun findResult(player1: RPS, player2: RPS): String = when (player1) {
        player2 -> "You tied!"
        RPS.ROCK -> if (player2 == RPS.PAPER) "You lost!" else "You won!"
        RPS.PAPER -> if (player2 == RPS.SCISSORS) "You lost!" else "You won!"
        RPS.SCISSORS -> if (player2 == RPS.ROCK) "You lost!" else "You won!"
    }
}
