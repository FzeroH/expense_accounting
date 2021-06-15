package com.example.expenseaccounting.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.expenseaccounting.MainActivity
import com.example.expenseaccounting.R
import com.example.expenseaccounting.fragments.dialogfragments.FilterDialogFragment

class FilterFragment : Fragment() {

    private lateinit var btnFilterBack: ImageView
    private lateinit var btnFilterSave: ImageView
    private lateinit var btnFilterPeriod: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        val v:View = inflater.inflate(R.layout.fragment_filter, container, false)
        btnFilterBack = v.findViewById(R.id.btn_filter_back)
        btnFilterSave = v.findViewById(R.id.btn_filter_save)
        btnFilterPeriod = v.findViewById(R.id.btn_filter_period)
        return v
    }

    @SuppressLint("ResourceAsColor")
    override fun onStart() {
        super.onStart()
        btnFilterBack.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_filterFragment_to_mainFragment)
        }
        btnFilterPeriod.setOnClickListener {
            FilterDialogFragment().show(childFragmentManager, FilterDialogFragment.TAG)
        }

    }
}
