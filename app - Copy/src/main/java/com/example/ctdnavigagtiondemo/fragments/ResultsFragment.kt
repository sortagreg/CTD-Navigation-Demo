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
import kotlinx.android.synthetic.main.fragment_start.*
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
        buttonPlayGame.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_playGameFragment)
        }
    }
}