package com.example.expenseaccounting.screens.statistics

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expenseaccounting.data.remote.expense.model.ExpenseResponseModel
import com.example.expenseaccounting.data.repository.Repository
import kotlinx.coroutines.launch

class StatisticsViewModel: ViewModel() {
    val expenseLiveData:MutableLiveData<List<ExpenseResponseModel>> = MutableLiveData()
    private val repository = Repository()

    fun fetchExpenseList() {
        try {
            viewModelScope.launch {
                val response = repository.fetchExpenseList()
                expenseLiveData.postValue(response)
            }
        } catch (e: Exception){
            Log.d("TAG", "Exception ${e.message}")
        }
    }
}