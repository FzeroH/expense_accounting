package com.example.expenseaccounting.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.expenseaccounting.MainActivity
import com.example.expenseaccounting.R

class MainFragment : Fragment() {

    private lateinit var addBtn: TextView
    private lateinit var filterBtn: TextView
    private lateinit var statisticsBtn: TextView
    private lateinit var settingsBtn: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val v: View = inflater.inflate(R.layout.fragment_main, container, false)
        addBtn = v.findViewById(R.id.btn_add)
        filterBtn = v.findViewById(R.id.btn_filter)
        statisticsBtn = v.findViewById(R.id.btn_statistics)
        settingsBtn = v.findViewById(R.id.btn_settings)
        return v
    }

    override fun onStart() {
        super.onStart()
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