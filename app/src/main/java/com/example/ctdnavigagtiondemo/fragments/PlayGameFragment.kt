package com.example.ctdnavigagtiondemo.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
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

        }
        binding.buttonPaper.setOnClickListener {

        }
        binding.buttonScissors.setOnClickListener {

        }
        return binding.root
    }

}
