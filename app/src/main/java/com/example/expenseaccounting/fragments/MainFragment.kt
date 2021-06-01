package com.example.expenseaccounting.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.expenseaccounting.MainActivity
import com.example.expenseaccounting.R
import java.util.zip.Inflater

class MainFragment : Fragment() {

    private lateinit var add_btn: TextView
    private lateinit var filter_btn: TextView
    private lateinit var statistics_btn: TextView
    private lateinit var settings_btn: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v: View = inflater.inflate(R.layout.fragment_main, container, false)
        add_btn = v.findViewById(R.id.add_btn)
        filter_btn = v.findViewById(R.id.filter_btn)
        statistics_btn = v.findViewById(R.id.statistics_btn)
        settings_btn = v.findViewById(R.id.settings_btn)
        return v
    }

    override fun onStart() {
        super.onStart()
        add_btn.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mainFragment_to_addExpenseFragment)
        }
        filter_btn.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mainFragment_to_filterFragment)
        }
        statistics_btn.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mainFragment_to_statisticsFragment)
        }
        settings_btn.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mainFragment_to_settingsFragment)
        }
    }
}