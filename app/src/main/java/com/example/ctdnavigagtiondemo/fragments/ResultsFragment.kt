package com.example.ctdnavigagtiondemo.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ctdnavigagtiondemo.R
import com.example.ctdnavigagtiondemo.databinding.FragmentResultsBinding
import com.example.ctdnavigagtiondemo.models.RPS


class ResultsFragment : Fragment() {

    private lateinit var binding: FragmentResultsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_results, container, false
        )

        val userChoice: RPS = arguments?.get(getString(R.string.USER_CHOICE)) as RPS
        val aiChoice = RPS.values().random()
        val result = findResult(userChoice, aiChoice)

        binding.apply {
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

        return binding.root
    }

    private fun findResult(player1: RPS, player2: RPS): String = when (player1) {
        player2 -> getString(R.string.tied)
        RPS.ROCK -> if (player2 == RPS.PAPER) getString(R.string.lost) else getString(R.string.won)
        RPS.PAPER -> if (player2 == RPS.SCISSORS) getString(R.string.lost) else getString(R.string.won)
        RPS.SCISSORS -> if (player2 == RPS.ROCK) getString(R.string.lost) else getString(R.string.won)
    }
}
