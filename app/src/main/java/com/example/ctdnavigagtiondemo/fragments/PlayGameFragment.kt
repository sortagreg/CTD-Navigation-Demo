package com.example.ctdnavigagtiondemo.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.ctdnavigagtiondemo.R
import com.example.ctdnavigagtiondemo.databinding.FragmentPlayGameBinding

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
            navigate()
        }
        binding.buttonPaper.setOnClickListener {
            navigate()
        }
        binding.buttonScissors.setOnClickListener {
            navigate()
        }
        return binding.root
    }

    private fun navigate() {
        findNavController().navigate(R.id.action_playGameFragment_to_resultsFragment)
    }
}
