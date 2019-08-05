package com.example.ctdnavigagtiondemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ctdnavigagtiondemo.R
import com.example.ctdnavigagtiondemo.databinding.FragmentPlayGameBinding
import com.example.ctdnavigagtiondemo.models.RPS

class PlayGameFragment : Fragment() {

    private lateinit var binding: FragmentPlayGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_play_game, container, false
        )

        binding.buttonRock.setOnClickListener {
            navigate(RPS.ROCK)
        }
        binding.buttonPaper.setOnClickListener {
            navigate(RPS.PAPER)
        }
        binding.buttonScissors.setOnClickListener {
            navigate(RPS.SCISSORS)
        }

        return binding.root
    }

    private fun navigate(userChoice: RPS) {
        val bundle = bundleOf(getString(R.string.USER_CHOICE) to userChoice)
        findNavController().navigate(R.id.action_playGameFragment_to_resultsFragment, bundle)
    }

}
