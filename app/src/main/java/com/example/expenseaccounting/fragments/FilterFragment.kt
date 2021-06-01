package com.example.expenseaccounting.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.expenseaccounting.MainActivity
import com.example.expenseaccounting.R

class FilterFragment : Fragment() {

    private lateinit var btn_filter_back: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v:View = inflater.inflate(R.layout.fragment_filter, container, false)
        btn_filter_back = v.findViewById(R.id.btn_filter_back)

        return v
    }

    override fun onStart() {
        super.onStart()
        btn_filter_back.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_filterFragment_to_mainFragment)
        }
    }
}