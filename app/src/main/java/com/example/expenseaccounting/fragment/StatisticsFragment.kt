package com.example.expenseaccounting.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.expenseaccounting.MainActivity
import com.example.expenseaccounting.R
import com.example.expenseaccounting.fragment.dialogfragment.FilterDialogFragment

class StatisticsFragment : Fragment() {

    private lateinit var btnStatisticsBack: ImageView
    private lateinit var btnStatisticsPeriod: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val v:View =  inflater.inflate(R.layout.fragment_statistics, container, false)

        btnStatisticsBack = v.findViewById(R.id.btn_statistics_back)
        btnStatisticsPeriod = v.findViewById(R.id.btn_statistics_period)
        return v
    }

    override fun onStart() {
        super.onStart()
        btnStatisticsBack.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_statisticsFragment_to_mainFragment)
        }
        btnStatisticsPeriod.setOnClickListener {
            FilterDialogFragment().show(childFragmentManager, FilterDialogFragment.TAG) //TODO: Создать новый фрагмент
        }
    }
}