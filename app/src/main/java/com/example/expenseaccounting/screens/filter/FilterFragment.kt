package com.example.expenseaccounting.screens.filter

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.icu.util.Calendar
import android.os.Bundle
import android.text.format.DateUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.expenseaccounting.MainActivity
import com.example.expenseaccounting.R
import moxy.MvpAppCompatFragment
import java.util.Calendar.getInstance


class FilterFragment : MvpAppCompatFragment() {

    private lateinit var btnFilterBack: ImageView
    private lateinit var btnFilterSave: ImageView
    private lateinit var btnFilterPeriodFrom: LinearLayout
    private lateinit var btnFilterPeriodTo: LinearLayout
    private lateinit var txtFilterPeriodFrom: TextView
    private lateinit var txtFilterPeriodTo: TextView
    private var calendarFrom: java.util.Calendar = getInstance()
    private var calendarTo: java.util.Calendar = getInstance()

    private var dateFrom =
        OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            calendarFrom.set(Calendar.YEAR, year)
            calendarFrom.set(Calendar.MONTH, monthOfYear)
            calendarFrom.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            setInitialDateFrom()
        }
    private var dateTo =
        OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            calendarTo.set(Calendar.YEAR, year)
            calendarTo.set(Calendar.MONTH, monthOfYear)
            calendarTo.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            setInitialDateTo()
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        val v:View = inflater.inflate(R.layout.fragment_filter, container, false)
        btnFilterBack = v.findViewById(R.id.btn_filter_back)
        btnFilterSave = v.findViewById(R.id.btn_filter_save)
        btnFilterPeriodFrom = v.findViewById(R.id.btn_filter_period_from)
        btnFilterPeriodTo = v.findViewById(R.id.btn_filter_period_to)
        txtFilterPeriodFrom = v.findViewById(R.id.filter_period_from)
        txtFilterPeriodTo = v.findViewById(R.id.filter_period_to)

        return v
    }

    @SuppressLint("ResourceAsColor")
    override fun onStart() {
        super.onStart()
        btnFilterBack.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_filterFragment_to_mainFragment)
        }
        btnFilterPeriodFrom.setOnClickListener {
            DatePickerDialog(
                requireContext(), dateFrom,
                calendarFrom.get(Calendar.YEAR),
                calendarFrom.get(Calendar.MONTH),
                calendarFrom.get(Calendar.DAY_OF_MONTH))
                .show()

        }
        btnFilterPeriodTo.setOnClickListener {
            DatePickerDialog(
                requireContext(), dateTo,
                calendarTo.get(Calendar.YEAR),
                calendarTo.get(Calendar.MONTH),
                calendarTo.get(Calendar.DAY_OF_MONTH))
                .show()

        }
    }
    @SuppressLint("SetTextI18n")
    private fun setInitialDateFrom() {
        txtFilterPeriodFrom.text ="от ${DateUtils.formatDateTime(context,calendarFrom.timeInMillis,
                DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR
            )}"
        Log.d("Date",calendarFrom.toString())
    }
    @SuppressLint("SetTextI18n")
    private fun setInitialDateTo(){
        txtFilterPeriodTo.text ="до ${DateUtils.formatDateTime(context,calendarTo.timeInMillis,
            DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR
        )}"
        Log.d("Date",calendarTo.toString())
    }
}
