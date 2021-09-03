package com.example.expenseaccounting.screens.addexpenses

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expenseaccounting.data.repository.Repository
import kotlinx.coroutines.launch

class AddExpenseViewModel: ViewModel() {

    private val repository = Repository()

    fun addExpense(title: String, price: Double, quantity: Int, comment: String?){
        viewModelScope.launch{
            try {
                repository.addExpense(
                    title = title,
                    price = price,
                    quantity = quantity,
                    comment = comment)
            } catch(e: Exception) {
                Log.d("TAG", "Exception ${e.message}")
            }
        }
    }
}