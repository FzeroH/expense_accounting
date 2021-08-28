package com.example.expenseaccounting.data.repository

import com.example.expenseaccounting.data.remote.expense.ExpenseAccountingResponse
import com.example.expenseaccounting.data.remote.expense.RetrofitInstance
import kotlinx.coroutines.Deferred
import retrofit2.Response

class Repository {
    
    //private val expenseAccountingApp = ExpenseAccountingApp()

    suspend fun fetchExpenseList(): Deferred<List<ExpenseAccountingResponse>> {
        return RetrofitInstance.api.getExpenseList()
    }

}