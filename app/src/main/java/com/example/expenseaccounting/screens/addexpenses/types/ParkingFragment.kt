package com.example.expenseaccounting.screens.addexpenses.types

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.expenseaccounting.MainActivity
import com.example.expenseaccounting.R


class ParkingFragment : Fragment() {

    private lateinit var btnParkingBack: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v: View =  inflater.inflate(R.layout.fragment_parking, container, false)
        btnParkingBack = v.findViewById(R.id.btn_parking_back)
        return v
    }

    override fun onStart() {
        super.onStart()

        btnParkingBack.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_parkingFragment_to_addExpenseFragment)
        }
    }
}