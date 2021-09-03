package com.example.expenseaccounting.data.remote.expense

import com.example.expenseaccounting.data.remote.expense.model.ExpenseRequestModel
import com.example.expenseaccounting.data.remote.expense.model.ExpenseResponseModel
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface ExpenseAccountingApi {


    @GET("./consumption")
    @Headers("Email: quqa@mail.ru","Content-Type:application/json")
    fun getExpenseList(): Deferred<List<ExpenseResponseModel>>

    @POST("./consumption/")
    @Headers("Email: quqa@mail.ru")
    suspend fun addExpense(@Body expenseRequestModel: ExpenseRequestModel)


}