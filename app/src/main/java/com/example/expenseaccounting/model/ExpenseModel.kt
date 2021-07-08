package com.example.expenseaccounting.model

import java.util.*

sealed class BaseExpenseModel( var date: Date, var cost: UInt, var comment: String?, var type:String){
    class FuelExpenseModel(date: Date, cost: UInt, comment: String?, var liters: UInt, type: String = "fuel") : BaseExpenseModel(date, cost, comment,
        type, )
    class ParkingExpenseModel(date: Date, cost: UInt, comment: String?, type: String = "parking") : BaseExpenseModel(date, cost,comment,
        type,)
    class WashExpenseModel(date: Date, cost: UInt, comment: String?, type: String = "wash") : BaseExpenseModel(
        date,
        cost,
        comment, type,
    )
}