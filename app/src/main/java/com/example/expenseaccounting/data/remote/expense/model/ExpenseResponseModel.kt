package com.example.expenseaccounting.data.remote.expense.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ExpenseResponseModel(

    @SerializedName("id")
    val expenseId: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("created_date")
    val date: String,

    @SerializedName("unit_price")
    val price: Double,

    @SerializedName("quantity")
    val quantity: Int,

    @SerializedName("comment")
    val comment: String
)
