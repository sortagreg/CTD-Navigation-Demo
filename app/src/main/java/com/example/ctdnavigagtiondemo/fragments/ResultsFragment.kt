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
        val userChoice: RPS = arguments?.get("user_choice") as RPS
        val aiChoice = RPS.values().random()
        val result = getResult(userChoice, aiChoice)


        textViewPlayerChoice.text = userChoice.name
        textViewAiChoice.text = aiChoice.name
        textViewResult.text = result

        buttonPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.action_global_startFragment)

        }

        buttonToPainting.setOnClickListener {
            findNavController().navigate(R.id.action_resultsFragment_to_creditsFragment)
        }

    }

    private fun getResult(person1: RPS, person2:RPS): String = when (person1){
        person2 -> getString(R.string.you_tied)

        RPS.ROCK -> if (person2 == RPS.PAPER) getString(R.string.you_lost) else getString(R.string.you_won)
        RPS.PAPER -> if (person2 == RPS.SCISSORS) getString(R.string.you_lost) else getString(R.string.you_won)
        RPS.SCISSORS -> if (person2 == RPS.ROCK) getString(R.string.you_lost) else getString(R.string.you_won)
    }
}
