package com.example.ctdnavigagtiondemo.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ctdnavigagtiondemo.R
import com.example.ctdnavigagtiondemo.models.RPS
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_results.*
import java.sql.PreparedStatement
import kotlin.math.nextDown
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

        val userChoice: RPS = arguments?.get(getString(R.string.USER_CHOICE)) as RPS

        textViewPlayerChoice.text = userChoice.name

        buttonPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.action_global_startFragment)
        }

        buttonCredit.setOnClickListener {
                findNavController().navigate(R.id.action_resultsFragment_to_creditsFragments)
        }

    }
}
