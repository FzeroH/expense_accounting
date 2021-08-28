package com.example.expenseaccounting

import android.app.Application
import android.util.Log
import com.example.expenseaccounting.data.remote.expense.ExpenseAccountingApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ExpenseAccountingApp:Application() {

    lateinit var expenseAccountingApi: ExpenseAccountingApi

    override fun onCreate(){
        super.onCreate()

        configureRetrofit()
    }

    private fun configureRetrofit() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        expenseAccountingApi = retrofit.create(ExpenseAccountingApi::class.java)

    }

    companion object {
        private const val BASE_URL: String = "http://80.76.42.97"
    }

}