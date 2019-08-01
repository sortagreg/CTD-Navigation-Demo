package com.example.ctdnavigagtiondemo.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
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

        val userChoice: RPS = arguments?.get(getString(R.string.arg_user_choice)) as RPS
        val aiChoice = getAiChoice()

        binding.textViewPlayerChoice.text = userChoice.name
        binding.textViewAiChoice.text = aiChoice.name
        binding.textViewResult.text = getResult(userChoice, aiChoice)

        binding.buttonPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.action_global_startFragment)
        }

        return binding.root
    }

    private fun getResult(userChoice: RPS, aiChoice: RPS): String {
        return when (userChoice) {
            aiChoice -> getString(R.string.tie_result)
            RPS.ROCK -> if (aiChoice ==RPS.PAPER) getString(R.string.lost_result) else getString(R.string.win_result)
            RPS.PAPER -> if (aiChoice == RPS.SCISSORS) getString(R.string.lost_result) else getString(R.string.win_result)
            RPS.SCISSORS -> if (aiChoice == RPS.ROCK) getString(R.string.lost_result) else getString(R.string.win_result)
        }
    }

    private fun getAiChoice(): RPS {
        return arrayOf(RPS.ROCK, RPS.PAPER, RPS.SCISSORS).random()
    }
}
