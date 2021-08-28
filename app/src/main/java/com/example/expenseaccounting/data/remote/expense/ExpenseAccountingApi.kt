package com.example.expenseaccounting.data.remote.expense

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers

interface ExpenseAccountingApi {


    @GET("./consumption")
    @Headers("Email: quqa@mail.ru","Content-Type:application/json")
    fun getExpenseList(): Deferred<List<ExpenseAccountingResponse>>


}