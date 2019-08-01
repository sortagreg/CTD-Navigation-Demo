package com.example.ctdnavigagtiondemo.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ctdnavigagtiondemo.R
import kotlinx.android.synthetic.main.fragment_play_game.*

class PlayGameFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_play_game, container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonRock.setOnClickListener {

        }
        buttonPaper.setOnClickListener {

        }
        buttonScissors.setOnClickListener {

        }
    }

}
