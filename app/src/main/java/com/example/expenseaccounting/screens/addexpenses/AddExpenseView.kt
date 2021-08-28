package com.example.expenseaccounting.screens.addexpenses

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value= AddToEndSingleStrategy::class)
interface AddExpenseView: MvpView{
}