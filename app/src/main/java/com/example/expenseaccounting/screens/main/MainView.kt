package com.example.expenseaccounting.screens.main

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value= AddToEndSingleStrategy::class)
interface MainView: MvpView {
}