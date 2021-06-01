package com.example.expenseaccounting.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.expenseaccounting.MainActivity
import com.example.expenseaccounting.R

class StatisticsFragment : Fragment() {

    private lateinit var btn_statistics_back: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v:View =  inflater.inflate(R.layout.fragment_statistics, container, false)

        btn_statistics_back = v.findViewById(R.id.btn_statistics_back)
        return v
    }

    override fun onStart() {
        super.onStart()
        btn_statistics_back.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_statisticsFragment_to_mainFragment)
        }
    }
}