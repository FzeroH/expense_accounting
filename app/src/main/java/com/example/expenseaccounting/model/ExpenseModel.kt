package com.example.expenseaccounting.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ExpenseModel(
    @SerializedName("id")
    val expenseId: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("created_date")
    val date: Calendar,

    @SerializedName("unit_price")
    val price: Double,

    @SerializedName("quantity")
    val quantity: Int,

    @SerializedName("comment")
    val comment: String)