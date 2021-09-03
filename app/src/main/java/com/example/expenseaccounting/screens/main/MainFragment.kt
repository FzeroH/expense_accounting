package com.example.expenseaccounting.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.expenseaccounting.MainActivity
import com.example.expenseaccounting.R
import com.github.mikephil.charting.charts.PieChart

class MainFragment : Fragment(){

    private lateinit var addBtn: TextView
    private lateinit var filterBtn: TextView
    private lateinit var statisticsBtn: TextView
    private lateinit var settingsBtn: TextView
    private lateinit var pieChart: PieChart


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val v: View = inflater.inflate(R.layout.fragment_main, container, false)
        addBtn = v.findViewById(R.id.btn_add)
        filterBtn = v.findViewById(R.id.btn_filter)
        statisticsBtn = v.findViewById(R.id.btn_statistics)
        settingsBtn = v.findViewById(R.id.btn_settings)
        pieChart = v.findViewById(R.id.pie_chart)
        return v
    }

    override fun onStart() {
        super.onStart()
        pieChart.visibility = GONE //Временная заглушка
        addBtn.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mainFragment_to_addExpenseFragment)
        }
        filterBtn.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mainFragment_to_filterFragment)
        }
        statisticsBtn.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_mainFragment_to_statisticsFragment)
        }
        settingsBtn.setOnClickListener{
            //Toast.makeText(context,"Раздел находится в разработке", LENGTH_LONG).show()
            (activity as MainActivity).navController.navigate(R.id.action_mainFragment_to_settingsFragment)
        }
    }
}