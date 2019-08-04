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

        val userChoice = arguments?.get(getString(R.string.USER_CHOICE)) as RPS;
        val userInt = when(userChoice) {
            RPS.ROCK -> 1
            RPS.PAPER -> 2
            RPS.SCISSORS -> 3
        }
        textViewPlayerChoice.text = userChoice.name

        val random = Random.nextInt(1, 3);
        val aiChoice = when(random) {
            1 -> RPS.ROCK
            2 -> RPS.PAPER
            3 -> RPS.SCISSORS
            else -> throw(IllegalArgumentException())
        }

        textViewAiChoice.text = aiChoice.name
        textViewResult.text = playRPS(userInt, random);

        buttonPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.action_global_startFragment)
        }

        buttonToCredits.setOnClickListener {
            findNavController().navigate(R.id.action_resultsFragment_to_creditsFragment)
        }
    }

    fun playRPS(userChoice: Int, AIChoice: Int): String {
        //0 is rock, 1 paper, 2 scissors
        val playerWinHash = (userChoice - AIChoice + 3) % 3;
        //System.out.println(playerWinHash);
        return when(playerWinHash) {
            1 -> "You win!!"
            2 -> "You lose!!"
            0 -> "Draw!!"
            else -> "Invalid input."
        }
    }
}
