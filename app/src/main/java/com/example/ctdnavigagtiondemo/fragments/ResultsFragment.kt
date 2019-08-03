package com.example.ctdnavigagtiondemo.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ctdnavigagtiondemo.R
import com.example.ctdnavigagtiondemo.rockpaperscissors.RPS
import com.example.ctdnavigagtiondemo.rockpaperscissors.RPSResult
import com.example.ctdnavigagtiondemo.rockpaperscissors.getWinner
import kotlinx.android.synthetic.main.fragment_results.*


class ResultsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(
            R.layout.fragment_results, container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val userChoice = arguments?.get(getString(R.string.USER_CHOICE)) as RPS
        val computerChoice = arguments?.get(getString(R.string.COMPUTER_CHOICE)) as RPS

        textViewPlayerChoice.text = userChoice.name
        textViewAiChoice.text = computerChoice.name // Wow those lines line up perfectly

        val winner = getWinner(
            playerChoice = userChoice,
            computerChoice = computerChoice
        )
        textViewResult.text = getString(when(winner) {
            RPSResult.PLAYER_WIN -> R.string.win_message
            RPSResult.COMPUTER_WIN -> R.string.loss_message
            RPSResult.TIE -> R.string.tie_message
        })

        buttonPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.action_global_startFragment)
        }
    }
}
