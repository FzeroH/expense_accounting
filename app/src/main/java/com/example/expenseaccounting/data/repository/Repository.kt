package com.example.expenseaccounting.data.repository

import com.example.expenseaccounting.data.remote.expense.model.ExpenseResponseModel
import com.example.expenseaccounting.data.remote.expense.RetrofitInstance
import com.example.expenseaccounting.data.remote.expense.model.ExpenseRequestModel

class Repository {
    
    //private val expenseAccountingApp = ExpenseAccountingApp()

    suspend fun fetchExpenseList(): List<ExpenseResponseModel> {
        return RetrofitInstance.api.getExpenseList().await()
    }

    suspend fun addExpense(title: String, price: Double, quantity: Int, comment: String?){
        return RetrofitInstance.api.addExpense(ExpenseRequestModel(
            title = title,
            price = price,
            quantity = quantity,
            comment = comment)
        )
    }

}