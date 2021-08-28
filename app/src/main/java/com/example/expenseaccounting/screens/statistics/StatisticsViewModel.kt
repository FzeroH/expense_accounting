package com.example.expenseaccounting.screens.statistics

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expenseaccounting.data.remote.expense.ExpenseAccountingApi
import com.example.expenseaccounting.data.remote.expense.ExpenseAccountingResponse
import com.example.expenseaccounting.data.repository.Repository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.launch
import retrofit2.Response

class StatisticsViewModel(): ViewModel() {
    val expenseLiveData:MutableLiveData<Deferred<List<ExpenseAccountingResponse>>> = MutableLiveData()

    private val compositeDisposable = CompositeDisposable()
    //private val TAG = StatisticsProvider::class.java.simpleName
    private val repository = Repository()


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun fetchExpenseList() {
        viewModelScope.launch {
            val response = repository.fetchExpenseList()
            expenseLiveData.postValue(response)
        }
    }
}