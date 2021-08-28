package com.example.expenseaccounting.screens.addexpenses.types

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.expenseaccounting.MainActivity
import com.example.expenseaccounting.R

class WashFragment : Fragment() {

    private lateinit var btnWashBack: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v: View =  inflater.inflate(R.layout.fragment_wash, container, false)
        btnWashBack = v.findViewById(R.id.btn_wash_back)
        return v
    }

    override fun onStart() {
        super.onStart()

        btnWashBack.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_washFragment_to_addExpenseFragment)
        }
    }
}