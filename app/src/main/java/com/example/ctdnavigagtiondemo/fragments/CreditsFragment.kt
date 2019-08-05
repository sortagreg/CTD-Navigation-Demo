package com.example.ctdnavigagtiondemo.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.example.ctdnavigagtiondemo.R
import kotlinx.android.synthetic.main.fragment_credits.*
import kotlinx.android.synthetic.main.fragment_results.*


/**
 * A simple [Fragment] subclass.
 *
 */
class CreditsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_credits, container, false)




    }


}
