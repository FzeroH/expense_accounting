package com.example.expenseaccounting.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.expenseaccounting.MainActivity
import com.example.expenseaccounting.R

class AddExpenseFragment : Fragment() {

    private lateinit var btnAddExpenseBack: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val v:View = inflater.inflate(R.layout.fragment_add_expense, container, false)
        btnAddExpenseBack = v.findViewById(R.id.btn_add_expense_back)

        return v
    }

    override fun onStart() {
        super.onStart()
        btnAddExpenseBack.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_addExpenseFragment_to_mainFragment)
        }
    }
}