package com.example.expenseaccounting.data.remote.expense.model

import com.google.gson.annotations.SerializedName

data class ExpenseRequestModel(

    @SerializedName("title")
    val title: String,

    @SerializedName("unit_price")
    val price: Double,

    @SerializedName("quantity")
    val quantity: Int,

    @SerializedName("comment")
    val comment: String?
)