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


     fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val userChoise: RPS = arguments?.get(getString(R.string.USER_CHOISE)) as RPS
        val aIInput :RPS
        var aIChoise = Random.nextInt(1, 3)
        when(aIChoise){

            1-> aIInput = RPS.ROCK
            2-> aIInput = RPS.PAPER
            3-> aIInput = RPS.SCISSORS
            else->"ERROR - INVALID ENTRY"
        }
        var aI : RPS = arguments?.get(getString(aIChoise)) as RPS
        textViewPlayerChoice.text = userChoise.name
        textViewAiChoice.text= aI.name
        when(userChoise){
            RPS.ROCK-> if (aI.equals(RPS.PAPER)) textViewResult.text = "You won!!!" else textViewResult.text = "You loose!!!"
            RPS.PAPER-> if (aI.equals(RPS.SCISSORS))textViewResult.text = "You won!!!" else textViewResult.text = "You loose!!!"
            RPS.SCISSORS-> if (aI.equals(RPS.ROCK))textViewResult.text = "You won!!!" else textViewResult.text = "You loose!!!"
        }
        buttonPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.action_global_startFragment)

        }
    }


}
}