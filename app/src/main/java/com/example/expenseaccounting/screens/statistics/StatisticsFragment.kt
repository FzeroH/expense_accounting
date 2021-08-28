package com.example.expenseaccounting.screens.statistics

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.text.format.DateUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.expenseaccounting.MainActivity
import com.example.expenseaccounting.R
import com.example.expenseaccounting.adapter.ExpenseAdapter

class StatisticsFragment : Fragment() {

   // @InjectPresenter
    //lateinit var mPresenter: StatisticsPresenter

    private lateinit var btnStatisticsBack: ImageView
    private lateinit var btnStatisticsPeriod: View
    private lateinit var txtStatisticsFrom: TextView
    private lateinit var listHistorySell: RecyclerView
    private lateinit var expenseAdapter: ExpenseAdapter
    private var calendarFrom: java.util.Calendar = java.util.Calendar.getInstance()

    private var dateFrom =
        DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            calendarFrom.set(Calendar.YEAR, year)
            calendarFrom.set(Calendar.MONTH, monthOfYear)
            calendarFrom.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            setInitialDateFrom()
        }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val v:View =  inflater.inflate(R.layout.fragment_statistics, container, false)

        btnStatisticsBack = v.findViewById(R.id.btn_statistics_back)
        btnStatisticsPeriod = v.findViewById(R.id.btn_statistics_period)
        txtStatisticsFrom = v.findViewById(R.id.statistics_period_from)
        listHistorySell = v.findViewById(R.id.list_history_sells)
        expenseAdapter = ExpenseAdapter()
        listHistorySell.adapter = expenseAdapter
        listHistorySell.setHasFixedSize(true)

        val statisticsViewModel = ViewModelProvider(this).get(StatisticsViewModel::class.java)
        statisticsViewModel.fetchExpenseList()
        statisticsViewModel.expenseLiveData.observe(viewLifecycleOwner, { response ->
                response?.let { expenseAdapter.setData(it)}
        })

        return v
    }

    override fun onStart() {
        super.onStart()
        btnStatisticsBack.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_statisticsFragment_to_mainFragment)
        }

        btnStatisticsPeriod.setOnClickListener {
            DatePickerDialog(
                requireContext(),dateFrom,
                calendarFrom.get(Calendar.YEAR),
                calendarFrom.get(Calendar.MONTH),
                calendarFrom.get(Calendar.DAY_OF_MONTH))
                .show()

        }
        //mPresenter.loadExpenseList()

    }

    @SuppressLint("SetTextI18n")
    private fun setInitialDateFrom() {
        txtStatisticsFrom.text ="от ${
            DateUtils.formatDateTime(context,calendarFrom.timeInMillis,
            DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR
        )}"
        Log.d("Date",calendarFrom.toString())
    }

/*
    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

    override fun startLoading() {
        TODO("Not yet implemented")
    }

    override fun endLoading() {
        TODO("Not yet implemented")
    }

    override fun setupExpenseList(expenseList: ArrayList<ExpenseModel>) {

    }*/


}